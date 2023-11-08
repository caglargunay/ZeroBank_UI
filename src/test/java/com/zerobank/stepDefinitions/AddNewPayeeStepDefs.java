package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> table) {

        Object[] array = table.values().toArray();

        int i = 0;
        for (WebElement each : payBillsPage.tablo) {
            each.sendKeys(array[i++].toString());
        }
        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        Assert.assertEquals(string, payBillsPage.alert.getText());
    }

}
