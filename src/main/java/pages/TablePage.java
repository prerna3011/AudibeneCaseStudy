package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DataBean;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends Basepage {

    private static Logger logger = LoggerFactory.getLogger(TablePage.class);

    @FindBy(xpath = "//*[@id='table1']/tbody/tr")
    protected List<WebElement> tableOne;

    @FindBy(xpath = "//*[@id='table2']/tbody/tr")
    protected List<WebElement> tableTwo;

    @FindBy(xpath = "//*[@id='content']/div/h4[1]")
    protected WebElement exampleOne;

    @FindBy(xpath = "//*[@id='table2']/thead/tr/th[2]/span")
    protected WebElement firstName;

    @FindBy(xpath = "//*[@id='table1']/thead/tr/th[1]/span")
    protected WebElement lastName;

    public TablePage() {
        initElements(this);
    }

    public boolean tableSize() {
        try {
            if (isElementDisplayed(exampleOne)) {
                List<WebElement> table1 = tableOne;
                DataBean.setTableOneLength(table1.size());

                List<WebElement> table2 = tableTwo;
                DataBean.setTableTwoLength(table2.size());

                logger.info("Size of table one is " + DataBean.getTableOneLength());
                logger.info("Size of table two is " + DataBean.getTableTwoLength());
                return true;
            }
        } catch (Exception e) {
            logger.error("Issue in fetching table size ::::" + e.getMessage());
        }
        logger.error("Issue in fetching table size");
        return false;
    }

    public boolean clickNameTableOne() {
        try {
            lastName.click();
            logger.info("Last name is clicked successfully for Table One");
            return true;
        } catch (Exception e) {
            logger.error("Last Name is not clicked successfully for Table One" + e.getMessage());
        }
        logger.error("Last Name is not clicked successfully for Table One");
        return false;
    }

    public boolean clickNameTableTwo() {
        try {
            firstName.click();
            logger.info("First name is clicked successfully for Table two");
            return true;
        } catch (Exception e) {
            logger.error("Name is not clicked successfully for Table Two " + e.getMessage());
        }
        logger.error("Name is not clicked successfully for Table Two");
        return false;
    }

    public boolean checkAscendingOrder(List<String> tableNames) {
        for (int i = 1; i < tableNames.size(); i++) {
            if (tableNames.get(i - 1).compareTo(tableNames.get(i)) > 0)
                return false;
        }
        logger.info("Names are set in ascending order");
        return true;
    }

    public boolean checkDescendingOrder(List<String> tableNames) {
        for (int i = 1; i < tableNames.size(); i++) {
            if (tableNames.get(i).compareTo(tableNames.get(i - 1)) > 0)
                return false;
        }
        logger.info("Names are set in descending order");
        return true;
    }

    public boolean VerifyTableOneOrder() {
        try {
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= DataBean.getTableOneLength(); i++) {
                result.add(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + i + "]/td[1]")).getText());
            }
            DataBean.setTableOneNames(result);
            logger.info("Table Last names are added in the list as " + DataBean.getTableOneNames());

            if (checkAscendingOrder(DataBean.getTableOneNames()) || checkDescendingOrder(DataBean.getTableOneNames())) {
                logger.info("List is sorted");
                return true;
            }

        } catch (Exception e) {
            logger.error("Last Names are not sorted successfully " + e.getMessage());
        }
        logger.error("Last Names are not sorted successfully");
        return false;
    }

    public boolean VerifyTableTwoOrder() {
        try {
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= DataBean.getTableTwoLength(); i++) {
                result.add(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[" + i + "]/td[2]")).getText());
            }
            DataBean.setTableTwoNames(result);
            logger.info("Table First name are added in the list as " + DataBean.getTableTwoNames());
            if (checkAscendingOrder(DataBean.getTableTwoNames()) || checkDescendingOrder(DataBean.getTableTwoNames())) {
                logger.info("List is sorted");
                return true;
            }

        } catch (Exception e) {
            logger.error("First Names are not sorted successfully " + e.getMessage());
        }
        logger.error("First Names are not sorted successfully");
        return false;
    }
}
