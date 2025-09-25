package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.multipleWindow.MultipleWindowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getMultipleWindowsPage();
    }

    @Test
    public void newWindowTest() {
        new MultipleWindowPage(driver)
                .openNewWindow()
                .switchToNewWindow()
                .verifyNewWindowByText("New Window")
                .verifyNewWindowByUrl("https://the-internet.herokuapp.com/windows/new");
    }
}
