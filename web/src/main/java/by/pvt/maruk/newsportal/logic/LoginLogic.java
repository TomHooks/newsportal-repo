package by.pvt.maruk.newsportal.logic;



/**
 * Created by yura on 14.05.2016.
 */
public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "123";






    public static boolean checkAdminLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }

    /*public static boolean checkUserLogin(String enterLogin, String enterPass) {
        i
        return ;
    }*/
}
