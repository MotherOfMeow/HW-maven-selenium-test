package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "frame-top")
    WebElement frameTop;

    public NestedFramesPage switchToTopFrame() {
        driver.switchTo().frame(frameTop);

        return this;
    }

    @FindBy(name = "frame-left")
    WebElement frameLeft;

    public NestedFramesPage switchToLeftFrame() {
        switchToTopFrame();
        driver.switchTo().frame(frameLeft);

        return this;
    }

    @FindBy(name = "frame-middle")
    WebElement frameMiddle;

    public NestedFramesPage switchToMiddleFrame() {
        switchToTopFrame();
        driver.switchTo().frame(frameMiddle);

        return this;
    }

    @FindBy(name = "frame-right")
    WebElement frameRight;

    public NestedFramesPage switchToRightFrame() {
        switchToTopFrame();
        driver.switchTo().frame(frameRight);

        return this;
    }

    @FindBy(name = "frame-bottom")
    WebElement frameBottom;

    public NestedFramesPage switchToBottomFrame() {
        driver.switchTo().frame(frameBottom);

        return this;
    }

    @FindBy(xpath = "/html/body")
    WebElement textInLeftFrame;

    public NestedFramesPage verifyIframeByText(String text) {
        Assert.assertTrue(shouldHaveText(textInLeftFrame, text, 1));
        return this;
    }
}
