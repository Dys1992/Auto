import common.SaveResponse;
import common.SaveSearchResponse;

import java.io.IOException;
import java.text.ParseException;

public class TestSaveData {
    public static void main(String[] args) throws IOException, ParseException {
        SaveSearchResponse saveResponse = new SaveSearchResponse();
        saveResponse.response("wx");
    }
}
