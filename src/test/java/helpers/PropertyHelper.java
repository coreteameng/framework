package helpers;

import enums.Browser;
import models.ConfigModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertyHelper {
    private InputStream inputStream;
    private static ConfigModel config;
    private Map<String, Browser> list;
    public PropertyHelper() {
        list = new HashMap<>();
        list.put("CHROME", Browser.CHROME);
        list.put("FIREFOX", Browser.FIREFOX);
        list.put("EDGE", Browser.EDGE);
        list.put("IEXPLORE", Browser.IEXPLORE);
        list.put("SAFARI", Browser.SAFARI);
        list.put("OPERA", Browser.OPERA);
    }

    public static String getEmailFormat() {
        return config.getEmailFormat();
    }

    public static String getPasswordFormat() {
        return config.getPasswordFormat();
    }

    public static Browser getBrowserType() {
        return config.getBrowser();
    }

    public ConfigModel getConfig() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
                config = new ConfigModel();
                String browser = prop.getProperty("browser");
                list.forEach((name, value) -> {
                    if (browser.toUpperCase().equalsIgnoreCase(name)) {
                        config.setBrowser(value);
                    }
                });
                String emailFormat = prop.getProperty("emailFormat");
                config.setEmailFormat(emailFormat);
                String passwordFormat = prop.getProperty("passwordFormat");
                config.setPasswordFormat(passwordFormat);
                inputStream.close();
                return config;
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            inputStream.close();
        }
        return null;
    }
}
