package helpers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import enums.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import runner.TestRunner;
public class DriverHelper {
    public static WebDriver webdriver;
    public static synchronized WebDriver createWebDriver(Browser browser) throws IOException {
        if (webdriver == null) {
            //  Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            webdriver = setDriversBrowser(BrowserHelper.validateBrowser(browser));

            webdriver.manage().deleteAllCookies();
            webdriver.manage().window().maximize();
            webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return webdriver;
    }

    public static synchronized WebDriver getCurrentDriver() throws IOException {
        if (webdriver == null) {
            createWebDriver(Browser.CHROME);
        }
        return webdriver;
    }

    public static WebDriver setDriversBrowser(Browser browser) throws IOException {
        WebDriver driver;
        OSFactory browserFactory = new OSFactory();
        driver = browserFactory.getInstance(browser).setupBrowser();
        return driver;
    }

    public static String takeScreenshot(String filename) throws IOException {
        try {
            File file = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.FILE);
            String filePath = ("./screenshot/" + filename + ".jpg");
            FileUtils.copyFile(file, new File(filePath));
            return filePath;
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            return null;
        }
    }

    public static void embedScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
            TestRunner.scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToReport(String string) {
        TestRunner.scenario.write(string);
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.out.println("Cleaning up the browser.");
            try {
                DriverHelper.webdriver.quit();
            } catch (NullPointerException e) {
                System.out.println("Browser already shut down.");
            }
        }
    }
}
