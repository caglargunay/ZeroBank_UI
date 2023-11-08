package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SearchStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();


    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(string);
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {

        if (accountActivityPage.descriptions.isEmpty()) Assert.fail(string + " not listed");

        for (WebElement each : accountActivityPage.descriptions) {
            System.out.println("each.getText() = " + each.getText());
            Assert.assertTrue(each.getText().contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

        if (accountActivityPage.descriptions.isEmpty()) Assert.fail(string + " not listed");

        for (WebElement each : accountActivityPage.descriptions) {
            System.out.println("False = " + each.getText());
            Assert.assertFalse(each.getText().contains(string));
        }
    }
}
