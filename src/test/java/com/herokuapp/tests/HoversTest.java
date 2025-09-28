package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.hover.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHoverPage();
    }

    @Test
    public void testHoverOnFirstAvatarTest() {
        new HoversPage(driver).hoverFirstAvatar().verifyNameByUserNumber(1);
    }


    @Test
    public void testHoverOnSecondAvatarTest() {
        new HoversPage(driver).hoverSecondAvatar().verifyNameByUserNumber(2);
    }

    @Test
    public void testHoverOnThirdAvatarTest() {
        new HoversPage(driver).hoverThirdAvatar().verifyNameByUserNumber(3);
    }
}
