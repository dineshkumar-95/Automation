package org.example.ui.demo;

import org.example.driver.DriverManager;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class HealeniumDemoTest extends BaseTest {
    @Override
    public void setupTestClass() throws Exception {
        Thread.sleep(500);
    }

//    @Test
    public void testLoginButton() {

        String path = new File("src/test/resources/demo/login.html").getAbsolutePath();

        DriverManager.getDriver().get("file://" + path);

        DriverManager.getDriver().findElement(By.id("loginButton")).click();

        System.out.println("Login button clicked successfully");
    }
    @Test
    public void testUserLogin() {

        String path = new File("src/test/resources/demo/login-v1.html").getAbsolutePath();
        DriverManager.getDriver().get("file://" + path);
        DriverManager.getDriver().findElement(By.id("loginButton")).click();
        System.out.println("Login button clicked");
    }

}
