package tests;

import org.testng.annotations.Test;
import pages.WindowPage;

import static org.assertj.core.api.Assertions.assertThat;
public class NewTabTest extends BaseTest {

    @Test(priority = 2, groups = {"sanity"})
    public void verifyNewTab() {
        logger.info("process:'verifyNewTab', event:'start-test'");
        String URL = url + "windows";
        webDriver.get(URL);

        WindowPage windowPage = new WindowPage();

        assertThat(windowPage.ClickForNewWindow()).isTrue();
        assertThat(windowPage.VerifyNewWindow()).isTrue();
        logger.info("process:'verifyNewTab', event:'end-test'");
    }
}
