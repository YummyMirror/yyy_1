package base;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * This is a base class of all Helper classes, which contains atomic methods
 * @author Anatoli
 */
public class HelperBase {

    protected WebDriver wd;
    private WaitFor wait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
        wait = new WaitFor(wd, 10);
    }

    /**
     * Method uses for open desired URL
     * @param url that will be opened
     */
    public void url(String url) {
        if (url != null && ! url.isEmpty()) {
            wd.navigate().to(url);
            wait.urlContains(url);
        }
    }

    /**
     * Method uses for entering text to textfields
     * @param locator of textfield WebElement
     * @param value that will be entered into textfield WebElement
     */
    protected void input(By locator, String value) {
        if (value != null && ! value.isEmpty()) {
            String currentValue = wd.findElement(locator).getAttribute("value");
            if (! value.equals(currentValue)) {
                wd.findElement(locator).click();
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(value);
            }
        }
    }

    /**
     * Method uses for clicking the desired WebElement
     * @param locator of WebElement that will be clicked
     */
    protected void click(By locator) {
        wait.elementClickable(locator).click();
    }

    protected void click(WebElement element) {
        wait.elementClickable(element).click();
    }

    /**
     * Method uses for checking if WebElement with given Locator is presented
     * @param locator of desired WebElement
     * @return TRUE if WebElement is presented on the web page
     */
    protected boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
}
