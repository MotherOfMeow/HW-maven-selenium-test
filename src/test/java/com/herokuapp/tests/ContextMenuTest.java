package com.herokuapp.tests;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.contextMenu.ContextMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getContextMenuPage();
    
    }

    @Test
    public void testContextMenuTest() {
        new ContextMenuPage(driver).rightClickOnContextMenuItem().verifySelectedContextMenu();
    }
}
