package models;

import interfaces.IOS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaModel implements IOS {
    @Override
    public WebDriver setupBrowser() {
        WebDriverManager.operadriver().clearPreferences();
        return new OperaDriver();
    }
}
