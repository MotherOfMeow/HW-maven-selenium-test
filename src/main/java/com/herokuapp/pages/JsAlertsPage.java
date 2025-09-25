package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JsAlertsPage extends BasePage {
    public JsAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/button")
    WebElement jsAlertButton;

    public JsAlertsPage clickOnForJsAlertButton() {
        click(jsAlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent())
                .accept();

        return this;
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/button")
    WebElement jsAlertButtonWithConfirm;

    public JsAlertsPage clickOnForJsAlertWithConfirmButton(String confirm) {
        click(jsAlertButtonWithConfirm);
        if (confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/button")
    WebElement jsAlertButtonWithPrompt;

    public JsAlertsPage clickOnForJsAlertWithPromptButton(String message) {
        click(jsAlertButtonWithPrompt);
        if (message!=null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }

        return this;
    }

    @FindBy(id = "result")
    WebElement resultText;

    public JsAlertsPage verifyJsAlert(String text) {
        Assert.assertTrue(resultText.getText().contains(text));

        return this;
    }
}
