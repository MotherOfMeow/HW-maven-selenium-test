package com.herokuapp.pages;

import com.herokuapp.pages.alert.JsAlertsPage;
import com.herokuapp.pages.contextMenu.ContextMenuPage;
import com.herokuapp.pages.dragAndDrod.DragAndDropPage;
import com.herokuapp.pages.dropdown.DropdownPage;
import com.herokuapp.pages.frame.FramesPage;
import com.herokuapp.pages.hover.HoversPage;
import com.herokuapp.pages.image.BrokenImagesPage;
import com.herokuapp.pages.multipleWindow.MultipleWindowPage;
import com.herokuapp.pages.slider.HorizontalSlidersPage;
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

    @FindBy(xpath = "//a[@href='/horizontal_slider']")
    WebElement horizontalSlider;

    public HorizontalSlidersPage getHorizontalSliderPage() {
        clickWithJS(horizontalSlider, 0, 600);

        return new HorizontalSlidersPage(driver);
    }

    @FindBy(xpath = "//a[@href='/hovers']")
    WebElement hover;

    public HoversPage getHoverPage() {
        clickWithJS(hover, 0, 600);

        return new HoversPage(driver);
    }

    @FindBy(xpath = "//a[@href='/context_menu']")
    WebElement contextMenu;

    public ContextMenuPage getContextMenuPage() {
        click(contextMenu);

        return new ContextMenuPage(driver);
    }

    @FindBy(xpath = "//a[@href='/dropdown']")
    WebElement dropdown;

    public DropdownPage getDropdownPage() {
        click(dropdown);

        return new DropdownPage(driver);
    }

    @FindBy(xpath = "//a[@href='/drag_and_drop']")
    WebElement dragAndDrop;

    public DragAndDropPage getDragAndDropPage() {
        click(dragAndDrop);

        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//a[@href='/broken_images']")
    WebElement brokenImages;

    public BrokenImagesPage getBrockenImagesTest() {
        click(brokenImages);

        return new BrokenImagesPage(driver);
    }
}
