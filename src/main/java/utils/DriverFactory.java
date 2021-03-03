package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public abstract class DriverFactory {

    public static final Logger logger = LogManager.getLogger(DriverFactory.class.getName());

    public static WebDriver createInstance(String browser) {
        WebDriver driver;

        if (browser.equals(DriverType.CHROME.name())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals(DriverType.FIREFOX.name())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals(DriverType.OPERA.name())) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            String errMsg = String.format("Browser [%s] not supported yet.", browser);
            logger.error(String.format("process:'createInstance', event:'%s'", errMsg));
            throw new IllegalArgumentException(errMsg);
        }
        return driver;
    }
}
