package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountsActivityStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("the Account Activity page should be displayed")
    public void the_account_activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Activity"));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {

        Select select = new Select(accountActivityPage.accounts);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains(option));
    }
}
