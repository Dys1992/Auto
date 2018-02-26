package model.flightresponsemodel;

import java.util.List;

/**
 * @author fy39919
 */
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

    public model.flightresponsemodel.HourLowestPrice getHourLowestPrice() {
        return HourLowestPrice;
    }

    public void setHourLowestPrice(model.flightresponsemodel.HourLowestPrice hourLowestPrice) {
        HourLowestPrice = hourLowestPrice;
    }

    public model.flightresponsemodel.TrainRecommand getTrainRecommand() {
        return TrainRecommand;
    }

    public void setTrainRecommand(model.flightresponsemodel.TrainRecommand trainRecommand) {
        TrainRecommand = trainRecommand;
    }

    public List<model.flightresponsemodel.FlightInfoSimpleList> getFlightInfoSimpleList() {
        return FlightInfoSimpleList;
    }

    public void setFlightInfoSimpleList(List<model.flightresponsemodel.FlightInfoSimpleList> flightInfoSimpleList) {
        FlightInfoSimpleList = flightInfoSimpleList;
    }

    public List<String> getRecommendFlights() {
        return RecommendFlights;
    }

    public void setRecommendFlights(List<String> recommendFlights) {
        RecommendFlights = recommendFlights;
    }

    public int getRefc() {
        return Refc;
    }

    public void setRefc(int refc) {
        Refc = refc;
    }

    public List<String> getCompanyList() {
        return CompanyList;
    }

    public void setCompanyList(List<String> companyList) {
        CompanyList = companyList;
    }

    public String getFlyOffCity() {
        return FlyOffCity;
    }

    public void setFlyOffCity(String flyOffCity) {
        FlyOffCity = flyOffCity;
    }

    public String getFlyOffCityCode() {
        return FlyOffCityCode;
    }

    public void setFlyOffCityCode(String flyOffCityCode) {
        FlyOffCityCode = flyOffCityCode;
    }

    public String getArriveCity() {
        return ArriveCity;
    }

    public void setArriveCity(String arriveCity) {
        ArriveCity = arriveCity;
    }

    public String getArriveCityCode() {
        return ArriveCityCode;
    }

    public void setArriveCityCode(String arriveCityCode) {
        ArriveCityCode = arriveCityCode;
    }

    public String getFlyOffCode() {
        return FlyOffCode;
    }

    public void setFlyOffCode(String flyOffCode) {
        FlyOffCode = flyOffCode;
    }

    public String getArriveCode() {
        return ArriveCode;
    }

    public void setArriveCode(String arriveCode) {
        ArriveCode = arriveCode;
    }

    public String getFlyOffTime() {
        return FlyOffTime;
    }

    public void setFlyOffTime(String flyOffTime) {
        FlyOffTime = flyOffTime;
    }
}
