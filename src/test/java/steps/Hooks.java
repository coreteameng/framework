package steps;

import helpers.ControlHelper;
import helpers.DriverHelper;
import helpers.PropertyHelper;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import models.ConfigModel;
import runner.TestRunner;

import java.io.IOException;


public class Hooks {
    private static Boolean runOnce = false;

    @Before
    public void beforeAll() throws IOException {
        ConfigModel config = new PropertyHelper().getConfig();
        DriverHelper.createWebDriver(config.getBrowser());
    }

    @Before
    public void before(Scenario scenario) {
        TestRunner.scenario = scenario;
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("After");
    }
}
