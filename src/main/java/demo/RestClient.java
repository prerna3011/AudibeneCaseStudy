package demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestClient {


  private static ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

  public static List<String> fetchCategories(){

    String BASE_URL = "https://api.chucknorris.io/jokes/categories";
    try {
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
      ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
      List<String> categories = mapper.readValue(response.getBody(),new TypeReference<List<String>>(){});
      return  categories;
    } catch (Exception e) {
      e.printStackTrace();

    }
   return new ArrayList<>();
  }
  public static SearchResponse search(String text){

    String BASE_URL = "https://api.chucknorris.io/jokes/search?query="+text;
    try {
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
      ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
      SearchResponse searchResponses = mapper.readValue(response.getBody(),SearchResponse.class);
      return  searchResponses;
    } catch (Exception e) {
      e.printStackTrace();

    }
    return null;
  }


  public static boolean checkIfContainsQueryString(SearchResponse searchResponses,String searchText) {
    boolean isExists = false;
    for(Item item : searchResponses.getResult()){
      System.out.println(item);

        if(item.getValue().contains(searchText)){
          isExists = true ;
        }
    }
    return  isExists;
  }

}
