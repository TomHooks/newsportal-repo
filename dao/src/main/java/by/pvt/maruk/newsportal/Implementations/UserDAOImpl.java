package by.pvt.maruk.newsportal.implementations;


import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 * Created by yura on 07.06.2016.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public User gerUserById(int id) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User result = new User();
        try {
            transaction = session.beginTransaction();

            result = (User) session.get(User.class,id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            throw new DAOException(e);
        } finally {
            session.close();
        }
        return result;
    }

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
    public String getUserPassword(String login) throws DAOException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        String result = null;
        User user  = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userLogin",login));
            user = (User) criteria.uniqueResult();
            transaction.commit();
            result = user.getUserPassword();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            throw new DAOException(e);
        } finally {
            session.close();
        }
        return result;

    }
}
