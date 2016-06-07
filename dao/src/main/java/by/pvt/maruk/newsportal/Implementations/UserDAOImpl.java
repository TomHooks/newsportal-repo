package by.pvt.maruk.newsportal.Implementations;

import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by yura on 07.06.2016.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();



    }

    @Override
    public User getUserPassword(String userLogin) {
        return null;
    }
}
