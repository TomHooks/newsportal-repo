package by.pvt.maruk.newsportal.dao;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.exceptions.DAOException;

import java.util.List;

/**
 * Created by yura on 09.06.2016.
 */
public interface NewDAO {

    List<New> getNews() throws DAOException;

    List<New> getNewsByUser(int i) throws DAOException;

    void addNew(New mynew) throws DAOException;

    New getNewById(int id) throws DAOException;





}
