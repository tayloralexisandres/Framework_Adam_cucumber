package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
    public DemoPage(){
        PageFactory.initElements(Driver.getDriver(),
                this);

    }
    @FindBy(xpath = "//li[.='Buttons']")
    public WebElement btn_button;

    public void options(String option){
        String locator="//li[.='"+option+"']";
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }


}
