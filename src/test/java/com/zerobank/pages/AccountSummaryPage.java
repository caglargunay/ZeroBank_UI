package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(css = "td a")
    public List<WebElement> links;

    public void clickLink(String link){
        for (WebElement each : links) {
            if(each.getText().equalsIgnoreCase(link)){
                each.click();
                break;
            }
        }
    }
}
