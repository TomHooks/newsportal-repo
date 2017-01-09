package by.pvt.maruk.newsportal.implementations;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by yura on 09.06.2016.
 */
public class NewDAOImpl implements NewDAO {

    @Override
    public List<New> getNews() throws DAOException {
        List<New> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(New.class);
            result = (List<New>) criteria.list();
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
    public void addNew(New aNew) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(aNew);
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
    public New getNewById(int id) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        New result = new New();
        try {
            transaction = session.beginTransaction();

            result = (New) session.get(New.class, id);
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


}
