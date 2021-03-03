package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigManager;

public class WindowPage extends Basepage {

    private static Logger logger = LoggerFactory.getLogger(TablePage.class);

    @FindBy(xpath = "//*[@id='content']/div/a")
    protected WebElement clickHereButton;

    @FindBy(className = "example")
    protected WebElement newWindowText;

    public WindowPage() {
        initElements(this);
    }

    public boolean ClickForNewWindow() {
        try {
            if (isElementDisplayed(clickHereButton)) {
                clickHereButton.click();

                logger.info("Click here button is clicked successfully ");
                return true;
            }
        } catch (Exception e) {
            logger.error("Click here button is not clicked successfully " + e.getMessage());
        }
        logger.error("Click here button is not clicked successfully");
        return false;
    }

    public boolean VerifyNewWindow() {
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            newWindowText.getText().equalsIgnoreCase("New Window");
            String url1 = driver.getCurrentUrl();
            String url2 = ConfigManager.getProperty("PageURL") + "windows/new";

            if (url1.equalsIgnoreCase(url2)) {
                logger.info("New window is verified successfully");
                return true;
            }
        } catch (Exception e) {
            logger.error("New window is not verified successfully " + e.getMessage());
        }
        logger.error("New window is not verified successfully");
        return false;
    }
}
