package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utility.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTransactionsStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    LocalDate fDate;
    LocalDate tDate;

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        fDate = BrowserUtils.convertStringToDate(fromDate);
        tDate = BrowserUtils.convertStringToDate(toDate);

        accountActivityPage.fromDate.clear();
        accountActivityPage.toDate.clear();

        accountActivityPage.fromDate.sendKeys(fromDate);
        accountActivityPage.toDate.sendKeys(toDate);

    }

    @When("clicks search")
    public void clicks_search() {

        accountActivityPage.findButton.click();
        BrowserUtils.sleep(2);

    }

    @Then("results table should only show transactions dates between {string} to  {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        LocalDate expectedfromDate = BrowserUtils.convertStringToDate(fromDate);
        LocalDate expectedToDate = BrowserUtils.convertStringToDate(toDate);

        for (WebElement each : accountActivityPage.getFromDate) {
            LocalDate eachDate = BrowserUtils.convertStringToDate(each.getText());

            Assert.assertTrue((eachDate.isAfter(expectedfromDate) || eachDate.isEqual(expectedfromDate)) && (eachDate.isBefore(expectedToDate) || eachDate.isEqual(expectedToDate)));

        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<LocalDate> datesActual = new ArrayList<>();
        List<LocalDate> datesSorted = new ArrayList<>();

        for (WebElement each : accountActivityPage.getFromDate) {

            datesActual.add(BrowserUtils.convertStringToDate(each.getText()));
            datesSorted.add(BrowserUtils.convertStringToDate(each.getText()));
        }
        Collections.sort(datesSorted, Collections.reverseOrder());

        Assert.assertEquals(datesSorted, datesActual);

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        boolean test = false;

        for (WebElement each : accountActivityPage.getFromDate) {
            if (each.getText().equalsIgnoreCase(string)) test = true;
        }
        Assert.assertFalse(test);

    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String header) {

        if (header.equals("Deposit")) {
            Assert.assertTrue(accountActivityPage.deposits.size() > 0);
            return;
        }

        if (header.equals("Withdrawal")) {
            Assert.assertTrue(accountActivityPage.witdrawals.size() > 0);
        }

    }

    @When("user selects type {string}")
    public void user_selects_type(String option) {

        Select type = new Select(accountActivityPage.type);
        type.selectByVisibleText(option);

    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String header) {

        if (header.equals("Deposit")) {
            Assert.assertFalse(BrowserUtils.webElementToStringList(accountActivityPage.witdrawals).contains(header));
        }

        if (header.equals("Withdrawal")) {
            Assert.assertFalse(BrowserUtils.webElementToStringList(accountActivityPage.deposits).contains(header));
        }


    }

}



