package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.dropdown.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDropdownPage();

    }

    @Test
    public void testDropdown() {
        new DropdownPage(driver)
                .clickDropdown()
                .selectByText("Option 1")
                .verifyChoosedOption("Option 1");
    }
}
