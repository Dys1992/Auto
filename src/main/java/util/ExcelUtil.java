package util;

import constants.FilePathConstants;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.flightrequestmodel.FlightInfo;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtil {
    public static final Logger log = Logger.getLogger(ExcelUtil.class);

    public static List<FlightInfo> getExcelData(String channel) throws FileNotFoundException {
        List<FlightInfo> keyList = new ArrayList<FlightInfo>();
        try {
            InputStream inputStream = new FileInputStream(FilePathConstants.excelFilePath);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(channel);
            int rows = sheet.getRows();
            int colums = sheet.getColumns();
            for (int i = 1; i <rows ; i++){
                FlightInfo flightInfo =new FlightInfo();
                flightInfo.setDepCode(sheet.getCell(0,i).getContents());
                flightInfo.setArrCode(sheet.getCell(1,i).getContents());
                keyList.add(flightInfo);
                log.debug("起抵机场:"+sheet.getCell(0,i).getContents()+" "+sheet.getCell(1,i).getContents());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return keyList;
    }

}
