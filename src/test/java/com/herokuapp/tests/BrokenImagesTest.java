package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.data.UrlData;
import com.herokuapp.pages.image.BrokenImagesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImagesTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBrockenImagesTest();

    }

    @Test
    public void testBrokenImagesTest() {
        new BrokenImagesPage(driver).verifyBrokenImages(UrlData.baseURL);
    }
}

