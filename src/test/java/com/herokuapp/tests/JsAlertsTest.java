package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JsAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsAlertsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJsAlertsPage();
    }

    @Test
    public void jsAlertTest() {
        new JsAlertsPage(driver)
                .clickOnForJsAlertButton()
                .verifyJsAlert("You successfully clicked an alert");
    }

    @Test
    public void jsAlertWithConfirmTest() {
        new JsAlertsPage(driver)
                .clickOnForJsAlertWithConfirmButton("OK")
                .verifyJsAlert("You clicked: Ok");
    }


    @Test
    public void jsAlertWithPromptTest() {
        new JsAlertsPage(driver)
                .clickOnForJsAlertWithPromptButton("Hello")
                .verifyJsAlert("You entered: Hello");
    }


}
