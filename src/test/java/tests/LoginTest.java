package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigManager;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(priority = 1, groups = {"login", "smoke"})
    public void loginWithExistingUser_is_successful() {
        logger.info("process:'loginWithExistingUser', event:'start-test'");
        String URL = url + "login";
        webDriver.get(URL);

        HomePage homepage = new HomePage();
        assertThat(homepage.signIn(ConfigManager.getProperty("userName"), ConfigManager.getProperty("password"))).isTrue();
        assertThat(homepage.Logout()).isTrue();
        logger.info("process:'loginWithExistingUser', event:'end-test'");
    }


}
