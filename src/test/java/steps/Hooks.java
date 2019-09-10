package steps;


import enums.Browser;
import helpers.DriverHelper;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import runner.TestRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.WeakHashMap;


public class Hooks {
    private static Boolean runOnce = false;

    @Before
    public void beforeAll() {


        DriverHelper.createWebDriver(Browser.CHROME);
        /*
        Capabilities capabilities = ((RemoteWebDriver) DriverHelper.getCurrentDriver()).getCapabilities();
        System.out.println(capabilities.getVersion());
        System.out.println(capabilities.getBrowserName());
        System.out.println(capabilities.getPlatform());
        System.out.println("before all calisti");
        */

    }

    @Before
    public void before(Scenario scenario) {
        TestRunner.scenario = scenario;
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            DriverHelper.embedScreenshot();
        }
    }
}
