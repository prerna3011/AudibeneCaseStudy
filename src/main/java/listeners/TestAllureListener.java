package listeners;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverManager;

public class TestAllureListener implements ITestListener {

    public static final Logger logger = LogManager.getLogger(TestAllureListener.class.getName());

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Png attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.error(String.format("process:'%s', event:'test-failure'", getTestMethodName(iTestResult)));
        WebDriver driver = DriverManager.getTlDriver();

        // Allure ScreenShotRobot
        if (driver instanceof WebDriver) {
            logger.info(String.format("process:'%s', event:'capture-screenshot'", getTestMethodName(iTestResult)));
            saveScreenshotPNG(driver);
        }
    }

}
