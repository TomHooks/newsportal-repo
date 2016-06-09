package by.pvt.maruk.newsportal.dao;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.exceptions.DAOException;

import java.util.List;

/**
 * Created by yura on 09.06.2016.
 */
public interface NewDAO {

    List<New> getNews() throws DAOException;

    void addNew(New mynew) throws DAOException;

}
