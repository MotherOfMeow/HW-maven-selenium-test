package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.dragAndDrod.DragAndDropPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDragAndDropPage();
    }

    @Test
    public void testDragAndDropTest() {
        new DragAndDropPage(driver).moveElementA().verifyDropped("A");
    }
}
