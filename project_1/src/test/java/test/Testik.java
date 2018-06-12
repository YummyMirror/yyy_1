package test;

import base.TestBase;
import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Testik extends TestBase {

    @BeforeMethod
    public void preCondition() {
        app.navigateTo().mainPage();
    }

    @Test
    public void test() {
        app.login().loginAs(new User().setLogin("admin")
                                      .setPassword("secret"));

        assertTrue(app.login().isUserLoggedIn());
    }

    @AfterMethod
    public void logout() {
        app.login().logout();
    }
}
