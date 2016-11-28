package by.pvt.maruk.newsportal.resource;

import by.pvt.maruk.newsportal.constants.ConfigConstants;

import java.util.ResourceBundle;

/**
 * Created by yura on 14.05.2016.
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle(ConfigConstants.MESSAGES_SOURCE);
    private static MessageManager instance;

    private MessageManager() {
    }

    public static synchronized MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
        }
        return instance;
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
