package by.pvt.maruk.newsportal.controller;


import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.exception.ServiceException;
import by.pvt.maruk.newsportal.services.impl.NewServiceImpl;
import by.pvt.maruk.newsportal.utils.RequestHandler;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by yura on 09.11.2016.
 */
public class MyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*HttpSession session = req.getSession();
        try {
            List<New> newList = NewServiceImpl.getInstance().getAll();
            session.setAttribute(Parameters.NEW_LIST, newList);

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
        RequestHandler.processRequest(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*  HttpSession session = req.getSession();
        try {
            List<New> newList = NewServiceImpl.getInstance().getAll();
            session.setAttribute(Parameters.NEW_LIST, newList);

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/

        RequestHandler.processRequest(req, resp);
    }
}
