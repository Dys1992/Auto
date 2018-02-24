package util;

import constants.FilePathConstants;
import model.flightrequestmodel.FlightInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtil {
    private static final Logger log = Logger.getLogger(ExcelUtil.class);

    public static List<FlightInfo> getExcelData(String channel) throws FileNotFoundException {
        List<FlightInfo> keyList = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream(FilePathConstants.excelFilePath);
            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheet(channel);
            HSSFRow hssfRow=sheet.getRow(1);
            int rows = sheet.getLastRowNum();
            int col = hssfRow.getPhysicalNumberOfCells();

            for (int i = 1; i < sheet.getLastRowNum() + 1 ; i++){
                HSSFRow row = sheet.getRow(i);
                if (row != null ){
                    FlightInfo flightInfo =new FlightInfo();
                    String dep = row.getCell(0).toString() ;
                    flightInfo.setDepCode(dep);
                    String arr = row.getCell(1).toString() ;
                    flightInfo.setArrCode(arr);
                    keyList.add(flightInfo);
                    log.info("测试航线" +i+":"+dep+"-"+arr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyList;
    }
}
