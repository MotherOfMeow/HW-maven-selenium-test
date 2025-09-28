package com.herokuapp.pages.hover;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/img")
    WebElement firstAvatar;

    public HoversPage hoverFirstAvatar() {
        new Actions(driver).moveToElement(firstAvatar).perform();

        return this;
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/img")
    WebElement secondAvatar;

    public HoversPage hoverSecondAvatar() {
        new Actions(driver).moveToElement(secondAvatar).perform();

        return this;
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/img")
    WebElement thirdAvatar;

    public HoversPage hoverThirdAvatar() {
        new Actions(driver).moveToElement(thirdAvatar).perform();

        return this;
    }

    @FindBy(xpath = "//*[@id='content']/div/div/div/h5")
    List<WebElement> userNames;

    public HoversPage verifyNameByUserNumber(int userNumber) {
        WebElement user = userNames.get(userNumber - 1);
        Assert.assertTrue(user.isDisplayed());

        return this;
    }

}
