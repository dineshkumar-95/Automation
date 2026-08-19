package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.constants.ConstantsWaits.*;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;
    protected Select select;

    Logger LOGGER = LogManager.getLogger(this.getClass());
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ONE_MIN_SECS));
    }
    protected void enterText(WebElement element, String text){
        element.sendKeys(text);
    }
    protected WebElement findElement(By by){
        return driver.findElement(by);
    }
    protected List<WebElement> findElements(By by){
        return driver.findElements(by);
    }
    protected void click(By by){
        driver.findElement(by).click();
    }
    protected void loadURL(String url){
        driver.get(url);;
    }
    protected void click(WebElement element){
        element.click();
    }
    protected void clickById(String idOfElement) {
        driver.findElement(By.id(idOfElement)).click();
    }
    protected void clickByName(String nameOfElement) {
        driver.findElement(By.name(nameOfElement)).click();
    }
    protected void clickByClassName(String classNameOfElement) {
        driver.findElement(By.className(classNameOfElement)).click();
    }

    protected void selectByVisibleText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }
    protected void selectByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }
    protected void selectByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }


    protected void setText(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void waitForElementToDisplay(WebElement element) {
//        sleepWait(1000);
        //LOGGER.info("Checking every 1 second until 30 seconds : " + element);
        for (int i = 1; i <= HALF_MIN_SECS; i++) {
            try {
                Thread.sleep(1000);
                if (element.isDisplayed()) {
                    LOGGER.info(element + " found within seconds : " + (i + 1));
                    break;
                }
            } catch (Exception e) {
            }
        }
    }
    protected void waitForElementToDisplay_fluent(By by) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
//        fluentWait.until(driver -> element.isDisplayed());
        fluentWait.until(driver -> findElement(by).isDisplayed());
        fluentWait.until(ExpectedConditions.elementToBeClickable(by));

    }
}
