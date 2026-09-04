package org.example.ui;

import org.example.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Override
    public void setupTestClass() throws Exception {

    }

    @Test
    public void loginTest(){
        homePage.waitForHomePageLoad();
        homePage.verifyHomePageLoad();
    }

}
