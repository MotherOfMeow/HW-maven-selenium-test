package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/nested_frames']")
    WebElement nestedFrames;

    public NestedFramesPage getNestedFramesPage() {
        click(nestedFrames);

        return new NestedFramesPage(driver);
    }
}
