package com.herokuapp.tests;

import com.herokuapp.pages.FramesPage;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.NestedFramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends  TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFramesPage();
        new FramesPage(driver).getNestedFramesPage();
    }
    
    @Test
    public void leftFrameTest() {
        new NestedFramesPage(driver).switchToLeftFrame().verifyIframeByText("LEFT");
    }

    @Test
    public void middleFrameTest() {
        new NestedFramesPage(driver).switchToMiddleFrame().verifyIframeByText("MIDDLE");
    }

    @Test
    public void rightFrameTest() {
        new NestedFramesPage(driver).switchToRightFrame().verifyIframeByText("RIGHT");
    }

    @Test
    public void bottomFrameTest() {
        new NestedFramesPage(driver).switchToBottomFrame().verifyIframeByText("BOTTOM");
    }
}

