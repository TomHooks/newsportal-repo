package by.pvt.maruk.newsportal.exceptions;



import org.hibernate.HibernateException;

/**
 * Created by yura on 07.06.2016.
 */
public class DAOException extends Exception{

    public DAOException(HibernateException e) {
        super(e);
    }

}
