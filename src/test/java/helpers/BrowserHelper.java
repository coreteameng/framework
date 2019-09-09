package helpers;

import enums.Browser;
import enums.Platform;
import interfaces.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.ExecutionException;

public class BrowserHelper implements IDriver {
    private static Browser DEFAULT_BROWSER = Browser.CHROME;
    private static Platform DEFAULT_PLATFORM = Platform.WINDOWS;
    private DesiredCapabilities capabilities;
    private WebDriver driver;

    public BrowserHelper(Platform platform, Browser browser) {
        DEFAULT_BROWSER = browser;
        DEFAULT_PLATFORM = platform;

        capabilities = new DesiredCapabilities();
        if (Platform.WINDOWS == platform) {
            capabilities.setCapability("os", "Windows");
            capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        } else if (Platform.OSX == platform) {
            capabilities.setCapability("os", "OS X");
            capabilities.setPlatform(org.openqa.selenium.Platform.MAC);
        }

        if (Browser.CHROME == browser) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/Desktop/HEYMAN-AI/framework/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (Browser.FIREFOX == browser) {
            driver = new FirefoxDriver();
        } else if (Browser.EDGE == browser) {
            driver = new EdgeDriver();
        }

    }


    @Override
    public WebDriver getBrowser() throws Exception {
        if (driver != null) {
            return driver;
        } else {
            return null;
        }
    }

    @Override
    public void openBrowser(String url) throws Exception {
        driver.get(url);
    }

    @Override
    public void closeBrowser() throws Exception {
        driver.close();

    }

    @Override
    public void closeAllBrowser() throws ExecutionException {
        driver.quit();
    }

    @Override
    public String getTitle() throws Exception {
        return driver.getTitle();
    }

    @Override
    public String getPageSource() throws Exception {
        return driver.getPageSource();
    }

    @Override
    public String getCurrentUrl() throws Exception {
        return driver.getCurrentUrl();

    }

    @Override
    public void navigateTo(String url) throws Exception {
        driver.navigate().to(url);
    }

    @Override
    public void navigateRefresh() throws Exception {
        driver.navigate().refresh();
    }

    @Override
    public void navigateForward() throws Exception {
        driver.navigate().forward();
    }

    @Override
    public void navigateBack() throws Exception {
        driver.navigate().back();
    }
}
