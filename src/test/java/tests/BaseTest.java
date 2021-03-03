package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ConfigManager;
import utils.DriverManager;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {

    public static final String url = ConfigManager.getProperty("PageURL");

    public static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    protected WebDriver webDriver;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(@NotNull String browser) {
        logger.info(String.format("process:'setup', event:'Initiating Browser', name:'%s'", browser.toUpperCase()));
        webDriver = DriverManager.getTlDriver(browser.toUpperCase());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("process:'tearDown', event:'Quiting Browser'");
        DriverManager.quitDriver();
    }
}
