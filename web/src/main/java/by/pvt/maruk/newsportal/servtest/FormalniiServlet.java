package by.pvt.maruk.newsportal.servtest;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;

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
 * Created by yura on 09.06.2016.
 */

@WebServlet(name = "Formalnii")
public class FormalniiServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<New> listOfNews = new ArrayList<New>();
        NewDAO newDAO = new NewDAOImpl();
        try {
            listOfNews =  newDAO.getNews();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute("list", listOfNews);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
