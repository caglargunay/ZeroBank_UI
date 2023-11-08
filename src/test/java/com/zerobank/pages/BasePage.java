package com.zerobank.pages;

import com.zerobank.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.SortedMap;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

   public WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @FindAll({
            @FindBy(tagName = "a"), //genearal
            @FindBy(css = "td a"), //account summary page
            @FindBy(className = "headers"), //online banking page  "headers"
            @FindBy(css = "#pages-nav li"), //online banking page "page links"
            @FindBy(css = "#tabs li")  //pay bills page
    })
    public List<WebElement> links;


    public void clickLinkFromWebElementList(String linkText) {

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        for (WebElement eachWebElement : links) {

            if (!eachWebElement.isEnabled() || !eachWebElement.isDisplayed()) continue;

            if (eachWebElement.getText().trim().equalsIgnoreCase(linkText)) {
                eachWebElement.click();
                Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return;
            }
        }

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        throw new RuntimeException(linkText + " is not found or clickable");
    }


}
