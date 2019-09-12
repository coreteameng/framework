package runner;


import io.cucumber.core.api.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"steps"},
        plugin = {"pretty"})
public class TestRunner {

    public static Map<String, String> config;
    public static Scenario scenario;
}