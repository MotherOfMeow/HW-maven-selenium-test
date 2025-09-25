package com.herokuapp.pages;

import com.herokuapp.pages.alert.JsAlertsPage;
import com.herokuapp.pages.frame.FramesPage;
import com.herokuapp.pages.multipleWindow.MultipleWindowPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    WebElement jsAlerts;

    public JsAlertsPage getJsAlertsPage() {
        clickWithJS(jsAlerts, 0, 400);

        return new JsAlertsPage(driver);
    }

    @FindBy(xpath = "//a[@href='/frames']")
    WebElement frames;

    public FramesPage getFramesPage() {
        click(frames);

        return new FramesPage(driver);
    }

    @FindBy(xpath = "//a[@href='/windows']")
    WebElement multipleWindows;

    public MultipleWindowPage getMultipleWindowsPage() {

        clickWithJS(multipleWindows, 0, 600);
        return new MultipleWindowPage(driver);
    }
}
