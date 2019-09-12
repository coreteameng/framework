package models;

import interfaces.IOS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class EdgeModel implements IOS {
    @Override
    public WebDriver setupBrowser() {
        WebDriverManager.edgedriver().clearPreferences();
        return new EdgeDriver();
    }
}
