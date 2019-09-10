package helpers;

import java.io.File;
import java.io.IOException;


import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import runner.TestRunner;

public class DriverHelper {

    public static WebDriver webdriver;

    public static synchronized WebDriver createWebDriver(Browser browser) {
        if (webdriver == null) {
            Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            webdriver = setDriversBrowser(BrowserHelper.validateBrowser(browser));
        }

        return webdriver;
    }

    public static synchronized WebDriver getCurrentDriver() {
        if (webdriver == null) {
            createWebDriver(Browser.CHROME);
        }

        return webdriver;


    }


    public static WebDriver setDriversBrowser(Browser browser) {
        switch (browser) {
            case CHROME:

                // Develop WebManagerDriver ---------
                System.out.println("CHROME");
                WebDriverManager.chromedriver().setup();
                /*
                System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/Desktop/HEYMAN-AI/framework/chromedriver.exe");
                return new ChromeDriver();
                */

            case EDGE:
                System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
                return new EdgeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return new FirefoxDriver();
            case IEXPLORE:
                System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                return new InternetExplorerDriver();
            case OPERA:
                System.setProperty("webdriver.opera.driver", "operadriver.exe");
                return new OperaDriver();
            case SAFARI:
                return new SafariDriver();
        }
        return null;
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
