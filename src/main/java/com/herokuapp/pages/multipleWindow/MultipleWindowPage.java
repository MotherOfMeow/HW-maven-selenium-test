package com.herokuapp.pages.multipleWindow;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MultipleWindowPage extends BasePage {

    String originalWindow;

    public MultipleWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement newWindow;

    public MultipleWindowPage openNewWindow() {
        click(newWindow);
        this.originalWindow = driver.getWindowHandle();

        return this;
    }

    public MultipleWindowPage switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(this.originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    @FindBy(xpath = "/html/body/div/h3")
    WebElement headerNewWindow;

    public MultipleWindowPage verifyNewWindowByText(String text) {
        Assert.assertTrue(shouldHaveText(headerNewWindow, text, 1));
        return this;
    }

    public MultipleWindowPage verifyNewWindowByUrl(String url) {
        Assert.assertTrue(shouldHaveUrl(url, 1));

        return this;
    }
}
