package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigManager;
import utils.DataBean;

public class ControlsPage extends Basepage {

    private static Logger logger = LoggerFactory.getLogger(TablePage.class);

    @FindBy(xpath = "//*[@id='input-example']/input")
    protected WebElement inputExample;

    @FindBy(xpath = "//*[@id='input-example']/button")
    protected WebElement swapButton;

    @FindBy(id = "message")
    protected WebElement messageDynamic;

    public ControlsPage() {
        initElements(this);
    }

    public boolean ClickEnableSwapButton() {
        try {
            if (!inputExample.isEnabled()) {
                logger.info("Input field is disabled");
                swapButton.getText().equalsIgnoreCase("Enable");
                logger.info("Button Name is Enable");
                swapButton.click();
                return true;
            }
        } catch (Exception e) {
            logger.error("Enable button is not clicked successfully " + e.getMessage());
        }
        logger.error("Enable button is not clicked successfully");
        return false;
    }

    public boolean ClickDisableSwapButton() {
        try {
            if (inputExample.isEnabled()) {
                logger.info("Input field is enabled");
                swapButton.getText().equalsIgnoreCase("Disable");
                logger.info("Button Name is Disable");
                swapButton.click();
                return true;
            }
        } catch (Exception e) {
            logger.error("Disable button is not clicked successfully " + e.getMessage());
        }
        logger.error("Disable button is not clicked successfully");
        return false;
    }

    public boolean VerifyEnableSuccessMessage() {
        try {
            if (isElementDisplayed(messageDynamic)) {
                inputExample.getText().equalsIgnoreCase(ConfigManager.getProperty("enableMessage"));
                logger.info("Success message is verified successfully for Enable");
                return true;
            }
        } catch (Exception e) {
            logger.error("Success message is not verified successfully for Enable" + e.getMessage());
        }
        logger.error("Success message is not verified successfully for Enable");
        return false;
    }

    public boolean VerifyDisableSuccessMessage() {
        try {
            if (isElementDisplayed(messageDynamic)) {
                inputExample.getText().equalsIgnoreCase(ConfigManager.getProperty("disableMessage"));
                logger.info("Success message is verified successfully for Disable ");
                return true;
            }
        } catch (Exception e) {
            logger.error("Success message is not verified successfully for Disable" + e.getMessage());
        }
        logger.error("Success message is not verified successfully for Disable");
        return false;
    }

    public boolean EnterValue(String input) {
        try {
            if (isElementDisplayed(inputExample)) {
                DataBean.setInputValue(input);
                inputExample.sendKeys(input);
                logger.info("Input value is entered successfully");
                return true;
            }
        } catch (Exception e) {
            logger.error("Input value is not entered successfully " + e.getMessage());
        }
        logger.error("Input value is not entered successfully");
        return false;
    }

    public boolean VerifyString() {
        try {
            if (inputExample.getAttribute("value").equalsIgnoreCase(DataBean.getInputValue())) {
                logger.info("Input value is matched successfully as " + DataBean.getInputValue());
                return true;
            }

        } catch (Exception e) {
            logger.error("Input value is not matched successfully as " + DataBean.getInputValue() + e.getMessage());
        }
        logger.error("Input value is not matched successfully");
        return false;
    }
}
