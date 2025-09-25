package com.herokuapp.tests;

import com.herokuapp.pages.frame.FramesPage;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.frame.NestedFramesPage;
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
        new NestedFramesPage(driver).switchToLeftFrame().verifyFrameByText("LEFT");
    }

    @Test
    public void middleFrameTest() {
        new NestedFramesPage(driver).switchToMiddleFrame().verifyFrameByText("MIDDLE");
    }

    @Test
    public void rightFrameTest() {
        new NestedFramesPage(driver).switchToRightFrame().verifyFrameByText("RIGHT");
    }

    @Test
    public void bottomFrameTest() {
        new NestedFramesPage(driver).switchToBottomFrame().verifyFrameByText("BOTTOM");
    }
}

