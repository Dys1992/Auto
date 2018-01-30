import common.GetSearchResponse;

import java.io.FileNotFoundException;
import java.util.List;

public class TestRespone {
    public static void main(String[] args) throws FileNotFoundException {
        GetSearchResponse getSearchResponse = new GetSearchResponse();
        List<String> list = getSearchResponse.getResponse("touch");
        for (int i = 0;i < list.size() ; i++){
            System.out.println(list.get(i));
        }

    }
}
