package steps;

import helpers.ControlHelper;
import helpers.DriverHelper;
import helpers.PropertyHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class example {
    ControlHelper helpers = new ControlHelper();

    public example() throws IOException {
        helpers = new ControlHelper();
    }

    @Given("User is already on {string} Page")
    public void user_is_already_on_Page(String page) throws Exception {
        helpers.openURL("https://www.google.com");

    }

    @When("title of {string} page is {string}")
    public void title_of_page_is(String pageName, String value) throws Exception {

    }

    @Then("user enters {string}, value : {string}")
    public void user_enters_value(String id, String value) throws Exception {
        helpers.setTextById(id,value);
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String id) throws Exception {
        helpers.clickButtonById(id);

    }

    @Then("Close the browser")
    public void close_the_browser() throws Exception {

    }

}
