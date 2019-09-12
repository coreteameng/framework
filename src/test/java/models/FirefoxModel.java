package models;

import interfaces.IOS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxModel implements IOS {
    @Override
    public WebDriver setupBrowser() {
        WebDriverManager.firefoxdriver().clearPreferences();
        return new FirefoxDriver();
    }
}
