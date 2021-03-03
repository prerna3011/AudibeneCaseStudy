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

//    @Test(priority = 2, groups = {"fail"})
//    public void showFailure() {
//        logger.info("process:'showFailure', event:'start-test'");
//
//        // Failing the test to show screenshot capturing
//        assertThat(1).isGreaterThan(2);
//
//        logger.info("process:'showFailure', event:'end-test'");
//    }

}
