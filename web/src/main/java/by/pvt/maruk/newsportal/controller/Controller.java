package by.pvt.maruk.newsportal.controller;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.command.ActionCommand;
import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.factory.ActionFactory;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;
import by.pvt.maruk.newsportal.resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yura on 13.05.2016.
 */
@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
//        определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (page == ConfigurationManager.getProperty("path.page.user")){
            List<New> listOfNews = new ArrayList<New>();
            NewDAO newDAO = new NewDAOImpl();
            try {
                listOfNews = newDAO.getNews();
            } catch (DAOException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", listOfNews);

            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

            dispatcher.forward(request, response);
        } else {

            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }

    }
}
