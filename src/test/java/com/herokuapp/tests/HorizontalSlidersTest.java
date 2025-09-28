package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.slider.HorizontalSlidersPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSlidersTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHorizontalSliderPage();
    }

    @Test
    public void testHorizontalSliderTest() {
        new HorizontalSlidersPage(driver).moveSliderInHorizontalDirection().verifySlider("4.5");

    }
}
