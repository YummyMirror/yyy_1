package application;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Application extends InitHelper {

    public void init(String browser) {
        wd = createDriver(browser);

        System.out.println("CAPABILITIES:" + ((HasCapabilities) wd).getCapabilities());
    }

    public void stop() {
        if (wd != null)
            wd.quit();
    }

    private WebDriver createDriver(String browser) {
        WebDriver wd = null;
        switch (browser) {
            case Browser.CHROME:
                wd = new ChromeDriver();
                break;
            case Browser.FIREFOX:
                FirefoxProfile profile = new FirefoxProfile();
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                ffOptions.setProfile(profile);
                wd = new FirefoxDriver(ffOptions);
                break;
            case Browser.IE:
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                ieOptions.ignoreZoomSettings();
                wd = new InternetExplorerDriver(ieOptions);
                break;
        }
        return wd;
    }
}
