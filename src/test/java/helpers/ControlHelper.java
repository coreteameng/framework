package helpers;


import interfaces.IControls;
import interfaces.IFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public  class ControlHelper implements IControls, IFunction {
    WebDriver webDriver = DriverHelper.getCurrentDriver();
    public ControlHelper() throws IOException {
    }

    public Capabilities getBrowserCapabilities() throws Exception {
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
        return cap;
    }

    @Override
    public void openURL(String url) throws Exception {
        webDriver.get(url);
    }

    @Override
    public void clickButtonById(String id) throws Exception {
        webDriver.findElement(By.id(id)).click();
    }

    @Override
    public String getTextById(String id) throws Exception {
        return webDriver.findElement(By.id(id)).getText();
    }

    @Override
    public void setTextById(String id, String value) throws Exception {
        webDriver.findElement(By.id(id)).sendKeys(value);
    }

    @Override
    public boolean isVisibleById(String id) throws Exception {
        return webDriver.findElement(By.id(id)).isDisplayed();
    }

    @Override
    public boolean isSelectedById(String id) throws Exception {
        return webDriver.findElement(By.id(id)).isSelected();
    }

    @Override
    public void clearTextById(String id) throws Exception {
        webDriver.findElement(By.id(id)).clear();

    }

    @Override
    public void selectViaVisibleTextById(String id, String value) throws Exception {
        Select dropdown = new Select(webDriver.findElement(By.id(id)));
        dropdown.selectByVisibleText(value);

    }

    @Override
    public void selectViaValueTextById(String id, String value) throws Exception {
        Select dropdown = new Select(webDriver.findElement(By.id(id)));
        dropdown.selectByValue(value);
    }

    @Override
    public void changeCheckStatusById(String id) throws Exception {
        WebElement option = webDriver.findElement(By.id(id));
        option.click();
    }

    @Override
    public boolean checkPasswordFormatById(String id) throws Exception {
        String pattern = PropertyHelper.getPasswordFormat();
        String pass = webDriver.findElement(By.id(id)).getText();
        Boolean result = pass.matches(pattern);
        return result;
    }

    @Override
    public boolean checkEmailFormatById(String id) throws Exception {
        String pattern = PropertyHelper.getEmailFormat();
        String pass = webDriver.findElement(By.id(id)).getText();
        Boolean result = pass.matches(pattern);
        return result;
    }
}
