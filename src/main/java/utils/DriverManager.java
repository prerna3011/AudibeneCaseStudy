package utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    private static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<>();

    public synchronized static WebDriver getTlDriver() {
        return tlWebDriver.get();
    }

    public synchronized static void setTlDriver(WebDriver driver) {
        tlWebDriver.set(driver);
    }

    public synchronized static WebDriver getTlDriver(String browser) {
        if (tlWebDriver.get() == null)
            setTlDriver(DriverFactory.createInstance(browser));
        return tlWebDriver.get();
    }

    public synchronized static void quitDriver() {
        WebDriver driver = tlWebDriver.get();
        if (driver != null) {
            driver.quit();
        }
    }
}
