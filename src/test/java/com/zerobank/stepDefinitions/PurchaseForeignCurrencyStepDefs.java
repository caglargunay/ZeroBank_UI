package com.zerobank.stepDefinitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utility.BrowserUtils;
import com.zerobank.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    HomePage homePage = new HomePage();
    PayBillsPage payBillsPage = new PayBillsPage();

    Select select;

    @When("user clicks {string} link")
    public void user_clicks_link(String linkText) {
        homePage.clickLinkFromWebElementList(linkText);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currency) {
        select = new Select(payBillsPage.selectCurrency);

        List<String> currencyList = BrowserUtils.webElementToStringList(select.getOptions());
        Assert.assertTrue(currencyList.containsAll(currency));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        payBillsPage.pcAmount.sendKeys("8");
        payBillsPage.dolarsCurrency.click();
        payBillsPage.calculateCostsButton.click();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        select = new Select(payBillsPage.selectCurrency);
        select.selectByIndex(3);
        payBillsPage.dolarsCurrency.click();
        payBillsPage.calculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.getDriver().switchTo().alert();
        homePage.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertFalse(alert.getText().isEmpty());
    }
}
