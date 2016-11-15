package by.pvt.maruk.newsportal.utils;

import by.pvt.maruk.newsportal.commands.ICommand;
import by.pvt.maruk.newsportal.commands.factory.CommandFactory;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yura on 10.11.2016.
 */
public class RequestHandler {
    private RequestHandler() {
    }
    public static void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.getInstance();
        ICommand сommand = commandFactory.defineCommand(request);
        String page = сommand.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE_PATH);
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
