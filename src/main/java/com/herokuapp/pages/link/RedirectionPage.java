package com.herokuapp.pages.link;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;

public class RedirectionPage extends BasePage {
    public RedirectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='status_codes/200']")
    WebElement statusCode200Page;

    public RedirectionPage click200StatusCodePage() {
        click(statusCode200Page);
        return this;
    }

    @FindBy(xpath = "//a[@href='status_codes/301']")
    WebElement statusCode301Page;

    public RedirectionPage click301StatusCodePage() {
        click(statusCode301Page);
        return this;
    }

    @FindBy(xpath = "//a[@href='status_codes/404']")
    WebElement statusCode404Page;

    public RedirectionPage click404StatusCodePage() {
        click(statusCode404Page);
        return this;
    }

    @FindBy(xpath = "//a[@href='status_codes/500']")
    WebElement statusCode500Page;

    public RedirectionPage click500StatusCodePage() {
        click(statusCode500Page);
        return this;
    }

    @Override
    public void verifyLinks(String baseUrl, String url) {
        try {
            if (url.startsWith("http://") || url.startsWith("https://")) {
                this.fullUrl = new URL(url);
            } else {
                this.fullUrl = new URL(baseUrl + "status_codes/" + url);
            }

            HttpURLConnection connection = (HttpURLConnection) fullUrl.openConnection();
            connection.setConnectTimeout(10000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                System.out.println(fullUrl + " - link cannot be accessed ( Response message is "
                        + connection.getResponseCode() + " " + connection.getResponseMessage() + ")");
            } else {
                System.out.println(fullUrl + " - link is accessible (Response message is "
                        + connection.getResponseCode() + " " + connection.getResponseMessage() + ")");
            }

        } catch (Exception e) {
            System.out.println(url + " - Error occurend: " + e.getMessage());
        }
    }

    @FindBy(tagName = "p")
    WebElement text;

    public RedirectionPage verifyStatusCodePageByText(String statusCode) {
        Assert.assertTrue(text.getText().contains("This page returned a " + statusCode + " status code."));

        return this;
    }
}
