package pojo;

import pojo.FlightInfoSimpleList;
import pojo.HourLowestPrice;
import pojo.NearCitys;
import pojo.TrainRecommand;

import java.util.List;

public class TouchFlightSearch {


    private HourLowestPrice HourLowestPrice;
    private TrainRecommand TrainRecommand;
    private List<FlightInfoSimpleList> FlightInfoSimpleList;
    private List<String> RecommendFlights;
    private int Refc;
    private List<String> CompanyList;
    private String FlyOffCity;
    private String FlyOffCityCode;
    private String ArriveCity;
    private String ArriveCityCode;
    private String FlyOffCode;
    private String ArriveCode;
 private String FlyOffTime;

    private NearCitys NearCitys;
    public void setHourLowestPrice(HourLowestPrice HourLowestPrice) {
        this.HourLowestPrice = HourLowestPrice;
    }
    public HourLowestPrice getHourLowestPrice() {
        return HourLowestPrice;
    }

    public void setTrainRecommand(TrainRecommand TrainRecommand) {
        this.TrainRecommand = TrainRecommand;
    }
    public TrainRecommand getTrainRecommand() {
        return TrainRecommand;
    }

    public void setFlightInfoSimpleList(List<FlightInfoSimpleList> FlightInfoSimpleList) {
        this.FlightInfoSimpleList = FlightInfoSimpleList;
    }
    public List<FlightInfoSimpleList> getFlightInfoSimpleList() {
        return FlightInfoSimpleList;
    }

    public void setRecommendFlights(List<String> RecommendFlights) {
        this.RecommendFlights = RecommendFlights;
    }
    public List<String> getRecommendFlights() {
        return RecommendFlights;
    }

    public void setRefc(int Refc) {
        this.Refc = Refc;
    }
    public int getRefc() {
        return Refc;
    }

    public void setCompanyList(List<String> CompanyList) {
        this.CompanyList = CompanyList;
    }
    public List<String> getCompanyList() {
        return CompanyList;
    }

    public void setFlyOffCity(String FlyOffCity) {
        this.FlyOffCity = FlyOffCity;
    }
    public String getFlyOffCity() {
        return FlyOffCity;
    }

    public void setFlyOffCityCode(String FlyOffCityCode) {
        this.FlyOffCityCode = FlyOffCityCode;
    }
    public String getFlyOffCityCode() {
        return FlyOffCityCode;
    }

    public void setArriveCity(String ArriveCity) {
        this.ArriveCity = ArriveCity;
    }
    public String getArriveCity() {
        return ArriveCity;
    }

    public void setArriveCityCode(String ArriveCityCode) {
        this.ArriveCityCode = ArriveCityCode;
    }
    public String getArriveCityCode() {
        return ArriveCityCode;
    }

    public void setFlyOffCode(String FlyOffCode) {
        this.FlyOffCode = FlyOffCode;
    }
    public String getFlyOffCode() {
        return FlyOffCode;
    }

    public void setArriveCode(String ArriveCode) {
        this.ArriveCode = ArriveCode;
    }
    public String getArriveCode() {
        return ArriveCode;
    }

/*    public void setFlyOffTime(Date FlyOffTime) {
        this.FlyOffTime = FlyOffTime;
    }
    public Date getFlyOffTime() {
        return FlyOffTime;
    }*/

    public void setNearCitys(NearCitys NearCitys) {
        this.NearCitys = NearCitys;
    }
    public NearCitys getNearCitys() {
        return NearCitys;
    }


    public String getFlyOffTime() {
        return FlyOffTime;
    }

    public void setFlyOffTime(String flyOffTime) {
        FlyOffTime = flyOffTime;
    }
}
