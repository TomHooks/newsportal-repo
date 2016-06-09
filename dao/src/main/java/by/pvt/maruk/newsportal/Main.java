package by.pvt.maruk.newsportal;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yura on 09.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        New mynew = new New();
        mynew.setNewsTitle("Ok!");
        mynew.setNewsContent("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        mynew.setNewsDate(new Date());
        NewDAO newDAO  = new NewDAOImpl();
        try {
            newDAO.addNew(mynew);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        List<New> listOfNews = new ArrayList<New>();
        try {
           listOfNews =  newDAO.getNews();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Iterator<New> iterator = listOfNews.iterator();
        while(iterator.hasNext()) {
           System.out.println(iterator.next());
        }


    }
}
