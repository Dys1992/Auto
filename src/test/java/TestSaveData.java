import common.SaveResponse;

import java.io.IOException;
import java.text.ParseException;

public class TestSaveData {
    public static void main(String[] args) throws IOException, ParseException {
        SaveResponse saveResponse = new SaveResponse();
        saveResponse.saveDate("wx");
    }
}
