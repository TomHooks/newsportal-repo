package by.pvt.maruk.newsportal.filter;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.commands.factory.CommandType;
import by.pvt.maruk.newsportal.constants.Parameters;
import by.pvt.maruk.newsportal.exception.ServiceException;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;
import by.pvt.maruk.newsportal.services.impl.NewServiceImpl;
import by.pvt.maruk.newsportal.utils.RequestParameterParser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by yura on 09.11.2016.
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession();
        ClientType clientType = RequestParameterParser.getClientType(httpServletRequest);

        try {
            CommandType commandType = RequestParameterParser.getCommandType(httpServletRequest);
            if (clientType == null) {
                if (commandType == CommandType.LOGIN) {
                    try {
                        List<New> newList = NewServiceImpl.getInstance().getAll();
                        httpSession.setAttribute(Parameters.NEW_LIST, newList);
                    } catch (DAOException e) {
                        e.printStackTrace();
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (commandType == CommandType.GOTOREGISTRATION) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (commandType == CommandType.GOTOHOWGUEST) {
                    try {
                        List<New> newList = NewServiceImpl.getInstance().getAll();
                        httpSession.setAttribute(Parameters.NEW_LIST, newList);
                    } catch (DAOException e) {
                        e.printStackTrace();
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    String page = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
                    RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);
                    dispatcher.forward(httpServletRequest, httpServletResponse);
                    httpSession.invalidate();
                }

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (IllegalArgumentException e) {
            String page = ConfigurationManager.getInstance().getProperty(PagePath.MAIN_PAGE_PATH);
            RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}