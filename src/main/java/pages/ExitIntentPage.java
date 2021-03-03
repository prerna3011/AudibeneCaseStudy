package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitIntentPage extends Basepage {

    private static Logger logger = LoggerFactory.getLogger(ExitIntentPage.class);

    @FindBy(className = "secondary")
    protected WebElement logout;

    @FindBy(xpath = "//*[@id='ouibounce-modal']/div[2]/div[3]")
    protected WebElement closeButton;

    public ExitIntentPage() {
        initElements(this);
    }

    public boolean MoveMouse() {
        try {
            Actions action = new Actions(driver);
            action.moveByOffset(600, -1).build().perform();
            closeButton.getText().equalsIgnoreCase("Close");
            return true;
        } catch (Exception e) {
            logger.error("Mouse was not moved successfully" + e.getMessage());
        }
        logger.error("Mouse was not moved successfully");
        return false;
    }

    public boolean VerifyAndClickCloseButton() {
        try {
            Actions a = new Actions(driver);
            WebElement as = closeButton;
            a.moveToElement(as).build().perform();
            return true;
        } catch (Exception e) {
            logger.error("Close button is not clicked successfully" + e.getMessage());
        }
        logger.error("Close button is not clicked successfully");
        return false;
    }
}
