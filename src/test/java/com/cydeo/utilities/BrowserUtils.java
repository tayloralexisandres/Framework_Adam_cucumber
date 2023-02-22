package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verify_title_contains(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {

                break;
            }

        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Driver.getDriver().quit();
    }

    public static void clicklink(String element) {
        Driver.getDriver().findElement(By.partialLinkText(element)).click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void waitForInvisibiltyOfGivenElement(WebElement target) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));

    }


    public static List<String> dropDownOptions_As_String(WebElement dropdownElement) {

        Select select = new Select(dropdownElement);
        List<WebElement> actualMonth_as_WebElement = select.getOptions();


        List<String> actualMonth_as_String = new ArrayList<>();

        for (WebElement each : actualMonth_as_WebElement) {
            actualMonth_as_String.add(each.getText());


        }

        return actualMonth_as_String;
    }

}