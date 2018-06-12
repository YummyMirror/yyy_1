package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * This class is the wrapper over the WebDriverWait class implementation
 * @author Anatoli
 */
public class WaitFor {

    private WebDriver wd;
    private WebDriverWait wait;

    public WaitFor(WebDriver wd, int timeout) {
        this.wd = wd;
        wait = new WebDriverWait(wd, timeout);
    }

    /**
     * Method is used for checking if URL contains expected text
     * @param url is text that is expected to see in URL
     * @return TRUE if URL contains input string
     */
    public boolean urlContains(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    /**
     * Method is uses for checking if element is clickable
     * @param locator of WebElement that will be checked on clickability
     * @return WebElement if it clickable
     */
    public WebElement elementClickable(By locator) {
        return wait.until(elementToBeClickable(locator));
    }

    /**
     * Method uses for checking if List of WebElements is visible
     * @param locator of List of WebElements, which will be checked on visibility
     * @return List of WebElements if them are visible
     */
    public List<WebElement> elementsVisible(By locator) {
        return wait.until(visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Method uses for checking if WebElement is visible
     * @param locator of WebElement, which will be checked on visibility
     * @return WebElement is it is visible
     */
    public WebElement elementVisible(By locator) {
        return wait.until(visibilityOfElementLocated(locator));
    }

    public String getNewWindow(Set<String> oldWindows) {
        return wait.until(waitForWindow(oldWindows));
    }

    private static ExpectedCondition<String> waitForWindow(Set<String> oldWindows) {
        return wd -> {
            Set<String> handles = wd.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.stream().findFirst().get() : null;
        };
    }
}
