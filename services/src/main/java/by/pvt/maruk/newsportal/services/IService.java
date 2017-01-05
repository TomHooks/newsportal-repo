package by.pvt.maruk.newsportal.services;

import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.exception.ServiceException;

import java.util.List;

/**
 * Created by Юра on 06.12.2016.
 */
public interface IService<T> {
    List<T> getAll() throws DAOException, ServiceException;

}
