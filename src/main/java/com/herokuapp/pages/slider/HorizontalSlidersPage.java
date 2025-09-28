package com.herokuapp.pages.slider;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HorizontalSlidersPage extends BasePage {
    public HorizontalSlidersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='content']/div/div/input")
    WebElement sliderInput;

    public HorizontalSlidersPage moveSliderInHorizontalDirection() {
        pause(1000);
        new Actions(driver).clickAndHold(sliderInput)
                .moveByOffset(50, 0)
                .release()
                .perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;

    public HorizontalSlidersPage verifySlider(String number) {
        Assert.assertEquals(range.getText(), number);

        return this;
    }
}
