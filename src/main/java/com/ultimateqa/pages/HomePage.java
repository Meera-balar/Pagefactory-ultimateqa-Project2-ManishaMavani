package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//li[@class = 'header__nav-item header__nav-sign-in']/a")
    WebElement signInLink;

    public void clickOnSignInLink(){
        Reporter.log("Clicking on SignIn Link from Homepage " + signInLink.toString());
        mouseHoverToElementAndClick(signInLink);
        CustomListeners.test.log(Status.PASS,"Click on ‘Sign In’ link");
    }
}
