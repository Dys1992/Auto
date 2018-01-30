package searchcase.wx.caselist;

import constants.FilePathConstants;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WxCompareNowTimeTest {

    @Test()
    public   void  wxSearchInfo()throws Exception {
        Workbook workbook = Workbook.getWorkbook(new FileInputStream(FilePathConstants.excelFilePath));
        Sheet sheet = workbook.getSheet("wxSaveResponseData1");
        List<String> list = null;
        int rows = sheet.getRows();
        Cell cell;
        for (int i = 0 ; i < rows ; i++ ){
            System.out.println(rows);
            list.add(sheet.getCell(3,i).getContents().toString());
        }
         Collections.sort(list);
        String time = list.get(0).toString();

    }
}
