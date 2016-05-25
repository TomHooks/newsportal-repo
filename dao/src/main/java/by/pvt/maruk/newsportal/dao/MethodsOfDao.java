package by.pvt.maruk.newsportal.dao;

import by.pvt.maruk.beans.Admin;
import by.pvt.maruk.beans.User;


import java.sql.*;
import java.util.ResourceBundle;


/**
 * Created by yura on 15.05.2016.
 */
public class MethodsOfDao implements Dao {
    private Connection connection;

    public MethodsOfDao() {
        ResourceBundle rb = ResourceBundle.getBundle("dataBaseConfig");

        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(rb.getString("url"), rb.getString("login"),
                    rb.getString("password"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static MethodsOfDao thisDao;

    public static synchronized MethodsOfDao getDao() {
        if (thisDao == null)
            thisDao = new MethodsOfDao();
        return thisDao;
    }

    @Override
    public User getUserPassword(String userLogin) {
        User user = null;
        try {
            String query = "select passuser from users where nameuser='" + userLogin + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                user = new User();
                user.setUserPassword(resultSet.getString("passuser"));
            } else {
                user = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Admin getAdminPassword(String adminLogin) {
        return null;
    }
}
