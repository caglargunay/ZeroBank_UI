package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class PayBillsPage extends BasePage{
    @FindBy(className = "control-label")
    public Map<WebElement,String> table;

    @FindBy(className = "controls")
    public List<WebElement> type;


    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(partialLinkText = "Add New Payee")
    public WebElement addNewPayee;


    @FindBy(id = "np_new_payee_address")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeedetails;


    @FindBy(css = "#ui-tabs-2 [class='control-group'] div *")
    public List<WebElement> tablo;

    @FindBy(css = ".ui-state-default a")
    public List<WebElement> paybills;

    @FindBy(id = "alert_content")
    public WebElement alert;

    @FindBy(id = "pc_currency")
    public WebElement selectCurrency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

    @FindBy(id = "pc_amount")
    public WebElement pcAmount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dolarsCurrency;


    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;


}
