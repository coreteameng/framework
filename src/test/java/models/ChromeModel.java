package models;

import interfaces.IOS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeModel implements IOS {

    @Override
    public WebDriver setupBrowser() {
        WebDriverManager.chromedriver().clearPreferences();
        return new ChromeDriver();
    }
}
