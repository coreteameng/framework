package helpers;

import interfaces.IControls;
import interfaces.IFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class ControlHelper implements IControls, IFunction {

    WebDriver driver;
    Properties properties;

    public ControlHelper(WebDriver driver) {
        this.driver = driver;
        this.properties = new Properties();
    }

    @Override
    public void clickButtonById(String id) throws Exception {
        driver.findElement(By.id(id)).click();
    }

    @Override
    public String getTextById(String id) throws Exception {
        return driver.findElement(By.id(id)).getText();
    }

    @Override
    public void setTextById(String id, String value) throws Exception {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    @Override
    public boolean isVisibleById(String id) throws Exception {
        return driver.findElement(By.id(id)).isDisplayed();
    }

    @Override
    public boolean isSelectedById(String id) throws Exception {
        return driver.findElement(By.id(id)).isSelected();
    }

    @Override
    public void clearTextById(String id) throws Exception {
        driver.findElement(By.id(id)).clear();

    }

    @Override
    public void selectViaVisibleTextById(String id, String value) throws Exception {
        Select dropdown = new Select(driver.findElement(By.id(id)));
        dropdown.selectByVisibleText(value);

    }

    @Override
    public void selectViaValueTextById(String id, String value) throws Exception {
        Select dropdown = new Select(driver.findElement(By.id(id)));
        dropdown.selectByValue(value);
    }

    @Override
    public void changeCheckStatusById(String id) throws Exception {
        WebElement option = driver.findElement(By.id(id));
        option.click();
    }

    @Override
    public boolean checkPasswordFormatById(String id) throws Exception {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        String pass = driver.findElement(By.id(id)).getText();
        Boolean result = pass.matches(pattern);
        return result;
    }

    @Override
    public boolean checkEmailFormatById(String id) throws Exception {
        String pattern = "^(.+)@(.+)$";
        String pass = driver.findElement(By.id(id)).getText();
        Boolean result = pass.matches(pattern);
        return result;
    }
}
