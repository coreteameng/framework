package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"driver", "com.heyman.web.steps", "runner"},
        tags = {"~@ignore"},
        plugin = {"json:target/RunCuke/cucumber.json",
                "pretty", "html:target/RunCuke/cucumber.html",
                "com.cucumber.listener.ExtentCucumberFormatter"})

public class TestRunner {


}
