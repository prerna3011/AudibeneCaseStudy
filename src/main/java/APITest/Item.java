package APITest;

import java.util.List;

public class Item {

  private List<String> categories;
  private String created_at ;
  private String icon_url;
  private String value ;

  @Override
  public String toString() {
    return "Item{" +
        "categories=" + categories +
        ", created_at='" + created_at + '\'' +
        ", icon_url='" + icon_url + '\'' +
        ", value='" + value + '\'' +
        '}';
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public void setIcon_url(String icon_url) {
    this.icon_url = icon_url;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public List<String> getCategories() {
    return categories;
  }

  public String getCreated_at() {
    return created_at;
  }

  public String getIcon_url() {
    return icon_url;
  }

  public String getValue() {
    return value;
  }
}
