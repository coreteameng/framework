package helpers;

import interfaces.IControls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ControlHelper implements IControls {

    WebDriver driver;

    public ControlHelper(WebDriver driver) {
        this.driver = driver;
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
}
