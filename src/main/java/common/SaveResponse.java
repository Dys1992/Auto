package common;

import com.alibaba.fastjson.JSON;
import common.DateUtil;
import constants.FilePathConstants;
import model.flightresponsemodel.Cabins;
import model.flightresponsemodel.FlightInfoSimpleList;
import model.flightresponsemodel.WxSreachBean;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.*;
import java.text.ParseException;
import java.util.List;

public class SaveResponse {
    public static final Logger log = Logger.getLogger(SaveResponse.class);


    public void saveDate(String channel) throws IOException, ParseException {

        GetSearchResponse getSearchResponse = new GetSearchResponse();
        List<String> list = getSearchResponse.getResponse(channel);
        InputStream inputStream = new FileInputStream(FilePathConstants.excelFilePath);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        String excelName = channel+ DateUtil.getNoSecondTime();
        HSSFSheet sheet = workbook.createSheet(excelName);

        for(int i=0;i<list.size();i++){
            List<FlightInfoSimpleList> flightList;
            List<Cabins> cabinsList;
            WxSreachBean jsonObject = JSON.parseObject(list.get(i), WxSreachBean.class);
            flightList = jsonObject.getFlightInfoSimpleList();

            for(int j=0;j<flightList.size();j++){
                int rows = sheet.getPhysicalNumberOfRows();
                cabinsList = flightList.get(j).getCabins();
                for(int k=0;k<cabinsList.size();k++){
                    HSSFRow row = sheet.createRow(k+rows+1);
                    row.createCell(0).setCellValue(flightList.get(j).getArriveAirportCode());
                    row.createCell(1).setCellValue(flightList.get(j).getOriginAirportCode());
                    row.createCell(2).setCellValue(flightList.get(j).getAirCompanyCode());
                    row.createCell(3).setCellValue(flightList.get(j).getFlyOffOnlyTime());
                    row.createCell(4).setCellValue(flightList.get(j).getFlightNo());
                    row.createCell(5).setCellValue(cabinsList.get(k).getRealRoomCode());
                    row.createCell(6).setCellValue(cabinsList.get(k).getFProductCode());
                    row.createCell(7).setCellValue(cabinsList.get(k).getMid());
                    row.createCell(8).setCellValue(cabinsList.get(k).getFpoid());
                    row.createCell(9).setCellValue(cabinsList.get(k).getFat());
                }
            }
        }
        try{
            FileOutputStream fos = new FileOutputStream(FilePathConstants.excelFilePath);
            workbook.write(fos);
            log.info("查询返回参数，保存Excel成功,文件地址为："+FilePathConstants.excelFilePath);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
