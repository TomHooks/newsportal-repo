package by.pvt.maruk.newsportal.resource;

import java.util.ResourceBundle;

/**
 * Created by yura on 14.05.2016.
 */
public class ConfigurationManager {
    private static  final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    private ConfigurationManager() {
    }
    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
