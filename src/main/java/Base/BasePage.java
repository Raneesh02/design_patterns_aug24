package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyHandler;

import java.time.Duration;

public abstract class BasePage {
    protected String url;
    protected WebDriver driver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        url = PropertyHandler.getProperty("url");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitAndClick(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected boolean isDisplayed(By locator){
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }catch (TimeoutException ignored){
        }
        System.out.println("element with locator : "+locator+" is not displayed");
        return false;
    }

    protected void waitAndSendKeys(By locator,String keysToSend){
        WebElement element=waitForVisible(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected WebElement waitForVisible(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void waitForInVisible(By locator){
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected String getText(By locator){
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }

    protected String getValue(By locator){
        waitForVisible(locator);
        return driver.findElement(locator).getAttribute("value");
    }



    protected String getSelectedOption(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        Select dropdown = new Select(element);
        return dropdown.getFirstSelectedOption().getText();
    }

    protected void waitAndSelect(By locator, String value){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        Select dropdown = new Select(element);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        dropdown.selectByVisibleText(value);
    }



}
