package by.pvt.maruk.newsportal.dao;

import by.pvt.maruk.newsportal.beans.Admin;
import by.pvt.maruk.newsportal.beans.User;

/**
 * Created by yura on 15.05.2016.
 */
public interface Dao {
    User getUserPassword(String userLogin);
    Admin getAdminPassword(String adminLogin);

}