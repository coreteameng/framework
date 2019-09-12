package models;

import interfaces.IOS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariModel implements IOS {
    @Override
    public WebDriver setupBrowser() {
        return new SafariDriver();
    }
}
