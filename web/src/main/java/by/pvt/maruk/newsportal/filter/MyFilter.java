package by.pvt.maruk.newsportal.filter;

import by.pvt.maruk.newsportal.constants.PagePath;
import by.pvt.maruk.newsportal.commands.factory.CommandType;
import by.pvt.maruk.newsportal.resource.ConfigurationManager;
import by.pvt.maruk.newsportal.utils.RequestParameterParser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (commandType == CommandType.GOTOREGISTRATION) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    String page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE_PATH);
                    RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);
                    dispatcher.forward(httpServletRequest, httpServletResponse);
                    httpSession.invalidate();
                }

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (IllegalArgumentException e) {
            String page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE_PATH);
            RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(page);
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}