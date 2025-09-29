package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.data.UrlData;
import com.herokuapp.pages.link.RedirectionPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedirectionTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getRedirectionPage();
    }

    @Test
    public void redirectWith200StatusCodeTest() {
        new RedirectionPage(driver)
                .click200StatusCodePage()
                .verifyStatusCodePageByText("200")
                .verifyLinks(UrlData.baseURL, "200");

    }
    @Test
    public void redirectWith301StatusCodeTest() {
        new RedirectionPage(driver)
                .click301StatusCodePage()
                .verifyStatusCodePageByText("301")
                .verifyLinks(UrlData.baseURL, "301");

    }
    @Test
    public void redirectWith404StatusCodeTest() {
        new RedirectionPage(driver)
                .click404StatusCodePage()
                .verifyStatusCodePageByText("404")
                .verifyLinks(UrlData.baseURL, "404");

    }
    @Test
    public void redirectWith500StatusCodeTest() {
        new RedirectionPage(driver)
                .click500StatusCodePage()
                .verifyStatusCodePageByText("500")
                .verifyLinks(UrlData.baseURL, "500");

    }


}
