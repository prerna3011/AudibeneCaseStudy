package tests;

import demo.RestClient;
import demo.SearchResponse;
import org.testng.annotations.Test;

import java.util.List;

 public class APITest extends BaseTest {

    private RestClient restclient;

    @Test(priority = 1, groups = {"login", "smoke"})
    void contextLoads() {
        List<String> categories = restclient.fetchCategories();
        String searchText = categories.get(0);
        SearchResponse searchResponses = restclient.search(searchText);
        logger.info(searchResponses.getTotal());
        boolean isContainQueryString = restclient.checkIfContainsQueryString(searchResponses, searchText);
        logger.info(isContainQueryString);
    }
}