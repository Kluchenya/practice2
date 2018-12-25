package test_setup;

import business.app_setup.ApplicationManager;
import core.utils.Logging.Log;
import core.utils.Logging.TestLogHelper;
import core.utils.PropertyManager;
import core.webdriver.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

import static core.utils.JSHelper.TakeScreenShot;


public class FunctionalTest {


    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws Exception {
        TestLogHelper.startTestLogging(getTestId());
        DriverManager.getInstance().getDriver().get(PropertyManager.getInstance().getUrl());
    }

    @BeforeMethod
    public void setUpLogin(Method method, Object[] param) {

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
    public void tearDown() {
        TestLogHelper.stopTestLogging();
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
