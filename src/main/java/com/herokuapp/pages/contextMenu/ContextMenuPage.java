package com.herokuapp.pages.contextMenu;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement contextMenuItem;

    public ContextMenuPage rightClickOnContextMenuItem() {
        new Actions(driver).contextClick(contextMenuItem).perform();

        return this;
    }

    public ContextMenuPage verifySelectedContextMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertNotNull(alert);

        return this;
    }
}
