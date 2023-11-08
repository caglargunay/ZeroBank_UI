package com.zerobank.stepDefinitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utility.ConfigurationReader;
import com.zerobank.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("userName"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @When("user clicks sing in button")
    public void user_clicks_sing_in_button() {
        loginPage.submitButon.click();

    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        Driver.getDriver().navigate().back();
        Assert.assertEquals(ConfigurationReader.getProperty("userName"), homePage.userName.getText());
    }

    @When("user enters {string} as username and  {string} as password")
    public void user_enters_as_username_and_as_password(String username, String password) {
        loginPage.loginInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String errorMessage) {

        Assert.assertEquals(errorMessage, loginPage.errorMessage.getText());
    }


}
