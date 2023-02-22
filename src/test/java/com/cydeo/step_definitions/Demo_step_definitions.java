package com.cydeo.step_definitions;

import com.cydeo.pages.ButtonsPAge;
import com.cydeo.pages.DemoPage;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Demo_step_definitions  {
DemoPage demoPage =new DemoPage();
ButtonsPAge buttonsPAge=new ButtonsPAge();
Actions actions=new Actions(Driver.getDriver());
    @Given("Navigate to {string} page")
    public void navigate_to_page(String option) {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        demoPage.options(option);
    }
    @When("Double click on button")
    public void double_click_on_button() {
        actions.doubleClick(buttonsPAge.buttonDoubleClick).perform();
    }
    @Then("Verify text double click message {string} should be visible")
    public void verify_text_double_click_message_should_be_visible(String expectedMessage) {
        Assert.assertEquals(expectedMessage,buttonsPAge.pDoubleClickMessage.getText());

    }
    @Then("Right click on button")
    public void right_click_on_button() {
        actions.contextClick(buttonsPAge.buttonRightClick).perform();
    }
    @Then("Verify text right click message {string} should be visible")
    public void verify_text_right_click_message_should_be_visible(String expectedMessageRightCLick) {
        Assert.assertEquals(expectedMessageRightCLick,buttonsPAge.pRightClickMessage.getText());

    }
    @Then("Click Me button")
    public void click_me_button() {
        actions.click(buttonsPAge.buttonClickMe).perform();
    }
    @Then("Verify text click me message {string} should be visible")
    public void verify_text_click_me_message_should_be_visible(String string) {
        Assert.assertEquals(string,buttonsPAge.pDynamicClickMessage.getText());

    }

}
