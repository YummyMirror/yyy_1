package helper;

import base.HelperBase;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void mainPage() {
        url("http://localhost/addressbook/");
    }
}
