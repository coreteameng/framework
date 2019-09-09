package steps;

import enums.Browser;
import enums.Platform;
import helpers.BrowserHelper;
import helpers.ControlHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class example {

    BrowserHelper browserHelper;
    ControlHelper controlHelper;

    @Given("User is already on {string} Page")
    public void user_is_already_on_Page(String page) throws Exception {
        System.out.println(page);
        browserHelper = new BrowserHelper(Platform.WINDOWS, Browser.CHROME);
        controlHelper = new ControlHelper(browserHelper.getBrowser());
        browserHelper.openBrowser(page);
    }

    @When("title of {string} page is {string}")
    public void title_of_page_is(String pageName, String value) throws Exception {
        System.out.println(pageName);
        Assert.assertEquals(browserHelper.getTitle(), value);
    }

    @Then("user enters {string}, value : {string}")
    public void user_enters_value(String id, String value) throws Exception {
        controlHelper.setTextById(id, value);
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String id) throws Exception {
        controlHelper.clickButtonById(id);
    }

    @Then("Close the browser")
    public void close_the_browser() throws Exception {
        browserHelper.closeBrowser();
    }

}
