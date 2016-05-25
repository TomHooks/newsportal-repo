package by.pvt.maruk.newsportal.resource;

import java.util.ResourceBundle;

/**
 * Created by yura on 14.05.2016.
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    private MessageManager() {
    }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
