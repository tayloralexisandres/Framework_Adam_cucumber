package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://demoqa.com/buttons
public class ButtonsPAge {
    @FindBy(xpath = "//*[@id='doubleClickBtn']")
    public WebElement buttonDoubleClick;

    @FindBy(xpath = "//*[@id='rightClickBtn']")
    public WebElement buttonRightClick;

    @FindBy(xpath = "//*[@id='WGjVl']")
    public WebElement buttonClickMe;

    @FindBy(xpath = "//*[@id='doubleClickMessage']")
    public WebElement pDoubleClickMessage;

    @FindBy(xpath = "//*[@id='rightClickMessage']")
    public WebElement pRightClickMessage;

    @FindBy(xpath = "//*[@id='dynamicClickMessage']")
    public WebElement pDynamicClickMessage;

    
   


    public ButtonsPAge() {
        PageFactory.initElements(
                Driver.getDriver(), this);
    }
}