package com.ultimateqa.testsuite;

import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.SignInPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class SignInPageTest extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnSignInLink();
        String expectedText = "Welcome Back!";
        Assert.assertEquals(signInPage.getWelcomeText(),expectedText,"Welcome Back! text not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage(){
        homePage.clickOnSignInLink();
        signInPage.enterEmail("Manisha@gmail.com");
        signInPage.enterPassword("test123");
        signInPage.clickOnSignButton();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals(signInPage.getErrorMessage(),expectedText,"Error message is not displayed");
    }
}
