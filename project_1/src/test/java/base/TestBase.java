package base;

import application.Application;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    protected Application app = new Application();
    private Application app2;

    protected Application app2() {
        if (app2 == null) {
            app2 = new Application();
        }
        return app2;
    }

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        app.init(browser);
        context.setAttribute("app1", app);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}
