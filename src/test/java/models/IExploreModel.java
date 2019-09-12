package models;

import interfaces.IOS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IExploreModel implements IOS {
    @Override
    public WebDriver setupBrowser() {
        WebDriverManager.iedriver().clearPreferences();
        return new InternetExplorerDriver();
    }
}
