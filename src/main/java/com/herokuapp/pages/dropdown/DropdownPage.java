package com.herokuapp.pages.dropdown;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdownSelect;

    public DropdownPage clickDropdown() {
        click(dropdownSelect);

        return this;
    }

    public DropdownPage selectByText(String text) {
        Select select = new Select(dropdownSelect);
        select.selectByVisibleText(text);

        return this;
    }

    @FindBy(css = "option[selected='selected']")
    WebElement selectedValue;

    public DropdownPage verifyChoosedOption(String text) {
        Assert.assertEquals(selectedValue.getText(), text);

        return this;
    }
}
