package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageSecond {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected BasePageSecond(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    protected WebDriver getDriver(){
        return  this.driver;
    }
    protected WebElement findElement(By by){
        return driver.findElement(by);

    }
    protected void click(By by){
        findElement(by).click();
    }
    protected void click(WebElement element){
        element.click();
    }
    protected void selectTextByVisibleText(WebElement element, String text){
        Select select  = new Select(element);
        select.selectByVisibleText(text);
    }
    protected void selectTextByValue(WebElement element, String Value){
        Select select  = new Select(element);
        select.selectByValue(Value);
    }
    protected void selectTextByIndex(WebElement element, int index){
        Select select  = new Select(element);
        select.selectByIndex(index);
    }
}
