/**
  * Copyright 2018 bejson.com 
  */
package model.flightresponsemodel;
import java.util.List;

/**
 * Auto-generated: 2018-01-23 19:8:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class NearCitys {

    private int IsNear;
    private String NearLineTip;
    private List<String> RecommendFlights;
    public void setIsNear(int IsNear) {
         this.IsNear = IsNear;
     }
     public int getIsNear() {
         return IsNear;
     }

    public void setNearLineTip(String NearLineTip) {
         this.NearLineTip = NearLineTip;
     }
     public String getNearLineTip() {
         return NearLineTip;
     }

    public void setRecommendFlights(List<String> RecommendFlights) {
         this.RecommendFlights = RecommendFlights;
     }
     public List<String> getRecommendFlights() {
         return RecommendFlights;
     }

}
