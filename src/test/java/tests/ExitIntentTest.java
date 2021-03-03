package tests;

import org.testng.annotations.Test;
import pages.ExitIntentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ExitIntentTest extends BaseTest {

    @Test(priority = 2, groups = {"sanity"})
    public void checkExitIntent() {
        logger.info("process:'checkExitIntent', event:'start-test'");
        String URL = url + "exit_intent";
        webDriver.get(URL);

        ExitIntentPage exitIntentPage = new ExitIntentPage();

        assertThat(exitIntentPage.MoveMouse()).isTrue();
        assertThat(exitIntentPage.VerifyAndClickCloseButton()).isTrue();
        logger.info("process:'checkExitIntent', event:'end-test'");
    }
}
