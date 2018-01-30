package util;

import constants.FilePathConstants;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.flightrequestmodel.FlightInfo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelUtil {

    public static List<FlightInfo> getExcelData() throws FileNotFoundException {
        List<FlightInfo> list = new ArrayList<FlightInfo>();
        try {
            InputStream inputStream = new FileInputStream(FilePathConstants.excelFilePath);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet("Sheet2");
            int rows = sheet.getRows();
            System.out.println(rows);
            for (int i = 1; i <rows ; i++){
                FlightInfo flightInfo =new FlightInfo();
                flightInfo.setDepCode(sheet.getCell(0,i).getContents());
                flightInfo.setArrCode(sheet.getCell(1,i).getContents());
                flightInfo.setUserIp(sheet.getCell(2,i).getContents());
                flightInfo.setFlat(sheet.getCell(3,i).getContents());
                flightInfo.setProductType(sheet.getCell(4,i).getContents());
                list.add(flightInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return list;
    }

}
