package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@class='dropdown-toggle']/i[@class='icon-user']/..")
    public WebElement userName;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBanking;

    @FindBy(css ="#pages-nav li")
    public List<WebElement> homaPageLinks;

}
