package utils;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Conditions.VISIBLE;

public abstract class SimpleAPI {

    protected abstract WebDriver getDriver();
    private static final Logger LOG = LogManager.getLogger(SimpleAPI.class);

    public void open(String url) {
        System.out.println(url + " is opening...");
        getDriver().get(url);
    }

    protected WebElement $(By locator) {
        return $(locator, VISIBLE);
    }

    protected WebElement $(String css) {
        return $(By.cssSelector(css));
    }

    protected WebElement $(By locator, Function<By, ExpectedCondition<WebElement>> condition) {
        return waitFor(condition.apply(locator));
    }

    protected WebElement $(By locator, Conditions condition) {
        return waitFor(condition.getCondition().apply(locator));
    }

    protected List<WebElement> $$(By locator) {
        return getDriver().findElements(locator);
    }

    protected List<WebElement> $$(String css) {
        return getDriver().findElements(By.cssSelector(css));
    }

    protected List<WebElement> $$(By locator, Function<By, ExpectedCondition<List<WebElement>>> condition) {
        return waitFor(condition.apply(locator));
    }

    protected List<WebElement> $$(By locator, int expNumberToBe) {
        return $$(locator, loc -> ExpectedConditions.numberOfElementsToBe(loc, expNumberToBe));
    }

/*    protected boolean $$(By locator, int elNo, String expText) {
        $$(locator, loc -> ExpectedConditions.(loc, elNo));
        return true;
    }*/

    protected <T> T waitFor(ExpectedCondition<T> condition, long timeout) {
        return (new WebDriverWait(getDriver(), timeout)).until(condition);
    }

    protected <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, 10l);
    }

    protected void waitForDocumentCompleteState() {
        try {
            waitFor(driver -> {
                String documentState = (String) ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState");
                LOG.debug("Current document state is: {}", documentState);
                return "complete".equals(documentState);
            }, 30);
        } catch (TimeoutException e) {
            LOG.warn("Can't wait till document.readyState is complete");
        }
    }



}