package APITest;

import java.util.List;

public class SearchResponse {

    private int total;
    private List<Item> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Item> getResult() {
        return result;
    }

    public void setResult(List<Item> result) {
        this.result = result;
    }
}
