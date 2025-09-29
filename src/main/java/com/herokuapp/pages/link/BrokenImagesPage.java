package com.herokuapp.pages.link;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenImagesPage verifyBrokenImages(String baseUrl) {
        System.out.println(images.size() + " -" + "images");
        for (WebElement element : images) {
            String imageURL = element.getDomAttribute("src");
            verifyLinks(baseUrl, imageURL);
            try {
                boolean imageDisplayed = (Boolean)
                        js.executeScript
                                ("return(typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", element);
                if (imageDisplayed) {
                    System.out.println("Display -> OK");
                } else {
                    System.out.println("Display -BROKEN");
                }
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
        return this;
    }
}
