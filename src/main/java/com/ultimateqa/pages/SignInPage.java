package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SignInPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement singInButton;
    @CacheLookup
    @FindBy(className = "form-error__list-item")
    WebElement errorMessage;
    public String getWelcomeText(){
        Reporter.log("Verify the text ‘Welcome Back!’ is displayed" + welcomeText.toString());
        String text =  getTextFromElement(welcomeText);
        CustomListeners.test.log(Status.PASS,"Get ‘Welcome Back!’ text");
        return text;
    }

    public void enterEmail(String email){
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField,email);
        CustomListeners.test.log(Status.PASS,"Enter email " + email);
    }

    public void enterPassword(String password){
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickOnSignButton(){
        Reporter.log("Clicking on SignIn Button " + singInButton.toString());
        mouseHoverToElementAndClick(singInButton);
        CustomListeners.test.log(Status.PASS,"Click on SignInButton");


    }
    public String getErrorMessage(){
        Reporter.log("Verify the error message ‘Invalid email or password.’ is displayed" + errorMessage.toString());
        String text =  getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS,"Get ‘Invalid email or password.’ text");
        return text;
    }

}
