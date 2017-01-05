package by.pvt.maruk.newsportal.services.impl;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.exception.ServiceException;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;
import by.pvt.maruk.newsportal.services.AbstractService;

import java.util.List;

/**
 * Created by Юра on 06.12.2016.
 */
public class NewServiceImpl extends AbstractService<New> {
    public static NewServiceImpl instance;

    private NewServiceImpl() {
    }

    public static synchronized NewServiceImpl getInstance() {
        if (instance == null) {
            instance = new NewServiceImpl();
        }
        return instance;
    }

    @Override
    public List<New> getAll() throws DAOException, ServiceException {
        List news;
        NewDAO newDAO = new NewDAOImpl();
        news = newDAO.getNews();
        return news;
    }
}
