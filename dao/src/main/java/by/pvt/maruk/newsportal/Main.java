package by.pvt.maruk.newsportal;

import by.pvt.maruk.newsportal.beans.New;
import by.pvt.maruk.newsportal.beans.User;
import by.pvt.maruk.newsportal.dao.NewDAO;
import by.pvt.maruk.newsportal.dao.UserDAO;
import by.pvt.maruk.newsportal.exceptions.DAOException;
import by.pvt.maruk.newsportal.implementations.NewDAOImpl;
import by.pvt.maruk.newsportal.implementations.UserDAOImpl;

import java.util.*;

/**
 * Created by yura on 09.06.2016.
 */
public class Main {
    public static void main(String[] args) {
//        New mynew = null;
        /*mynew.setNewsTitle("Добра");
        mynew.setNewsContent("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        mynew.setNewsDate(new Date());
        NewDAO newDAO  = new NewDAOImpl();
        try {
            newDAO.addNew(mynew);
        } catch (DAOException e) {
            e.printStackTrace();
        }*/
       /* List<New> listOfNews = new ArrayList<New>();
        try {
           listOfNews =  newDAO.getNews();
        } catch (DAOException e) {
            e.printStackTrace();
        }*/

        /*Iterator<New> iterator = listOfNews.iterator();
        while(iterator.hasNext()) {
           System.out.println(iterator.next());
        }*/
       /* NewDAO newDAO = new NewDAOImpl();
        try {
            mynew = newDAO.getNewById(1);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        System.out.println(mynew);*/
//        int z = 1;
//       NewDAO myNew = new NewDAOImpl();
//        try {
//            List<New> newsList =  myNew.getNewsByUser(z);
//            Iterator<New> iterator = newsList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }

        UserDAO myUser = new UserDAOImpl();
        int x =2;
        try { User newUser;
            newUser = myUser.gerUserById(x);
            Set<New> newSet = newUser.getNewsSet();
            Iterator<New> iterator = newSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (DAOException e) {
            e.printStackTrace();
        }




    }

    }

