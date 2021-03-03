package pages;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.FindBy;
import utils.ConfigManager;

public class HomePage extends Basepage {

    private static Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(className = "secondary")
    protected WebElement logout;

    @FindBy(id = "homeslider")
    protected WebElement slider;

    @FindBy(id = "flash")
    protected WebElement successMessage;

    @FindBy(id = "username")
    protected WebElement userName;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(className = "radius")
    protected WebElement login;

    public HomePage() {
        initElements(this);
    }

    public boolean signIn(String existingUserEmail, String existingUserPassword) {
        try {
            isElementDisplayed(userName);
            isElementDisplayed(password);
            isElementDisplayed(login);
            enterText(userName, existingUserEmail);
            enterText(password, existingUserPassword);
            login.click();
            logger.info("Login button is clicked successfully");
            return true;
        } catch (Exception e) {
            logger.error("Login button is not clicked successfully" + e.getMessage());
        }
        logger.error("Login button is not clicked successfully");
        return false;
    }

    public boolean isLogoutDisplayed() {
        try {
            if (isElementDisplayed(successMessage) &&
                    successMessage.getText().contains(ConfigManager.getProperty("successMessage"))) {
                logger.info("User is logged in and Success Message is verified'");
                return true;
            } else if (isElementDisplayed(successMessage) &&
                    successMessage.getText().contains(ConfigManager.getProperty("errorMessage"))) {
                logger.error("Logout is not displayed and Error message is verified successfully");
                return false;
            }
        } catch (Exception e) {
            logger.error("Success message is not verified successfully" + e.getMessage());
        }
        return false;
    }

    public boolean Logout() {
        try {
            if (isLogoutDisplayed()) {
                logout.click();
                logger.info("User has clicked on Logout button");
                successMessage.getText().contains(ConfigManager.getProperty("logoutSuccessMessage"));
                logger.info("Logout Message is verified");
                return true;
            } else if (!isLogoutDisplayed()) {
                logger.error("Either userName or Password was invalid");
                return false;
            }
        } catch (Exception e) {
            logger.error("Logout button was not clicked successfully" + e.getMessage());
        }
        logger.error("Logout button was not clicked successfully");
        return false;
    }
}
