package by.pvt.maruk.newsportal.dao;

import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.exceptions.DAOException;

/**
 * Created by yura on 07.06.2016.
 */
public interface UserDAO {

    void addUser(User user) throws DAOException;
    String getUserPassword(String userLogin) throws DAOException;
    User gerUserById (int id) throws DAOException;
}
