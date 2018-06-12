package application;

import helper.LoginHelper;
import helper.NavigationHelper;
import org.openqa.selenium.WebDriver;

public class InitHelper {

    protected WebDriver wd;
    protected NavigationHelper navigationHelper;
    protected LoginHelper loginHelper;

    public WebDriver getWd() {
        return wd;
    }

    public NavigationHelper navigateTo() {
        if (navigationHelper == null)
            navigationHelper = new NavigationHelper(wd);
        return navigationHelper;
    }

    public LoginHelper login() {
        if (loginHelper == null)
            loginHelper = new LoginHelper(wd);
        return loginHelper;
    }
}
