package test;

import annotation.Source;
import base.TestBase;
import dataProvider.AllDataProviders;
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

    @Test(dataProviderClass = AllDataProviders.class, dataProvider = "validUsers")
    @Source(value = "user.csv")
    public void test(User user) {
        app.login().loginAs(user);

        assertTrue(app.login().isUserLoggedIn());
    }

    @AfterMethod
    public void logout() {
        app.login().logout();
    }
}
