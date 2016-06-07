package by.pvt.maruk.newsportal.implementations;

import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by yura on 07.06.2016.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            throw new DAOException(e);
        } finally {
            session.close();
        }


    }

    @Override
    public User getUserPassword(String userLogin) {
        return null;
    }
}
