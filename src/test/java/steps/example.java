package steps;


import helpers.ControlHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Capabilities;

public class example {

    @Given("User is already on {string} Page")
    public void user_is_already_on_Page(String page) throws Exception {
        System.out.println(page);
        ControlHelper helpers = new ControlHelper();
        helpers.openURL("https://www.google.com");

        /*
        String url = "http://www.google.com";
        String node = "http://192.168.56.1:5555/wd/hub";
        System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/Desktop/HEYMAN-AI/framework/chromedriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        options.merge(capabilities);

        WebDriver driver = new RemoteWebDriver(new URL(node), options);
        driver.navigate().to(url);


        //browserHelper = new BrowserHelper(Platform.WINDOWS, Browser.CHROME);
        //controlHelper = new ControlHelper(browserHelper.getBrowser());
        //browserHelper.openBrowser(page);
        */

    }

    @When("title of {string} page is {string}")
    public void title_of_page_is(String pageName, String value) throws Exception {

    }

    @Then("user enters {string}, value : {string}")
    public void user_enters_value(String id, String value) throws Exception {

    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String id) throws Exception {

    }

    @Then("Close the browser")
    public void close_the_browser() throws Exception {

    }

}
