package helper;

import base.HelperBase;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {

    public LoginHelper(WebDriver wd) {
        super(wd);
    }

    public void loginAs(User user) {
        input(By.xpath("//input[@name = 'user']"), user.getLogin());
        input(By.xpath("//input[@name = 'pass']"), user.getPassword());
        click(By.xpath("//input[@value = 'Login']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//form[@name = 'logout']"));
    }

    public void logout() {
        By logoutButton = By.xpath("//form[@name = 'logout']/a");
        if (isElementPresent(logoutButton))
            click(logoutButton);
    }
}
