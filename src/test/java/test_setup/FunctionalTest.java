package test_setup;

import business.app_setup.ApplicationManager;
import core.utils.Logging.Log;
import core.utils.Logging.TestLogHelper;
import core.utils.PropertyManager;
import core.webdriver.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import static core.utils.JSHelper.TakeScreenShot;


public class FunctionalTest {


    protected final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUpSuite() {
        DriverManager.getInstance().getDriver().get(PropertyManager.getInstance().getUrl());
    }

    @BeforeClass
    public void setUp() throws Exception {
        TestLogHelper.startTestLogging(getTestId());

    }

    @BeforeMethod
    public void setUpLogin(Method method, Object[] param) {
    //    DriverManager.getInstance().getDriver().get(PropertyManager.getInstance().getUrl());
        Log.info("Start test " + method.getName() + " with parameters - " + Arrays.asList(param).toString());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result, Method method, Object[] param) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakeScreenShot(result.getName());
            Log.error("Test " + method.getName() + " failure!!!");
        } else {
            Log.info("Stop test " + method.getName() + " with parameters - " + Arrays.asList(param).toString());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        TestLogHelper.stopTestLogging();
       // DriverManager.getInstance().quit();
    }

    @AfterSuite
    public void tearDownSuite(){
        DriverManager.getInstance().quit();
    }

    private String getTestId() {
        String testId = null;
        return ((testId == null) ? (this.getClass().getSimpleName()) : testId);
    }

    public ApplicationManager getApp() {
        return app;
    }
}
