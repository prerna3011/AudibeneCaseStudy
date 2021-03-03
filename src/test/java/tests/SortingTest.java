package tests;

import org.testng.annotations.Test;
import pages.ExitIntentPage;
import pages.TablePage;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest extends BaseTest {

    @Test(priority = 2, groups = {"sanity"})
    public void sortingNames() {
        logger.info("process:'sortingNames', event:'start-test'");
        String URL = url + "tables";
        webDriver.get(URL);

        TablePage tablePage = new TablePage();

        assertThat(tablePage.tableSize()).isTrue();
        assertThat(tablePage.clickNameTableOne()).isTrue();
        assertThat(tablePage.clickNameTableTwo()).isTrue();
        assertThat(tablePage.VerifyTableOneOrder()).isTrue();
        assertThat(tablePage.VerifyTableTwoOrder()).isTrue();
        logger.info("process:'sortingNames', event:'end-test'");
    }
}
