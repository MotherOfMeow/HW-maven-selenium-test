package com.herokuapp.pages.dragAndDrod;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement dragMe;

    @FindBy(id = "column-b")
    WebElement dropHere;

    public DragAndDropPage moveElementA() {
        new Actions(driver).dragAndDrop(dragMe,dropHere).perform();

        return  this;
    }

    public DragAndDropPage verifyDropped(String text) {
        Assert.assertTrue(shouldHaveText(dropHere,text,5));

        return this;
    }
}
