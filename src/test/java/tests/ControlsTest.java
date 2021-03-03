package tests;

import org.testng.annotations.Test;
import pages.ControlsPage;
import pages.ExitIntentPage;
import utils.ConfigManager;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlsTest extends BaseTest {

    @Test(priority = 2, groups = {"sanity"})
    public void checkExitIntent() {
        logger.info("process:'checkExitIntent', event:'start-test'");
        String URL = url + "dynamic_controls";
        webDriver.get(URL);

        ControlsPage controlsPage = new ControlsPage();

        assertThat(controlsPage.ClickEnableSwapButton()).isTrue();
        assertThat(controlsPage.VerifyEnableSuccessMessage()).isTrue();
        assertThat(controlsPage.EnterValue(ConfigManager.getProperty("EnterValue"))).isTrue();
        assertThat(controlsPage.ClickDisableSwapButton()).isTrue();
        assertThat(controlsPage.VerifyDisableSuccessMessage()).isTrue();
        assertThat(controlsPage.VerifyString()).isTrue();
        logger.info("process:'checkExitIntent', event:'end-test'");
    }
}
