package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id="aa_accountId")
    public WebElement accounts;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(xpath = "//h2[.='Show Transactions']")
    public WebElement headerFindTransactions;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(xpath = "//*[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement>  getFromDate;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement>  descriptions;


    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement>  deposits;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement>  witdrawals;








}
