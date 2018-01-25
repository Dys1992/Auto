/**
  * Copyright 2018 bejson.com 
  */
package pojo;
import java.util.List;

/**
 * Auto-generated: 2018-01-23 19:8:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HourLowestPrice {

    private List<String> LowestPrice;
    private int MaxIndex;
    private int MinIndex;
    public void setLowestPrice(List<String> LowestPrice) {
         this.LowestPrice = LowestPrice;
     }
     public List<String> getLowestPrice() {
         return LowestPrice;
     }

    public void setMaxIndex(int MaxIndex) {
         this.MaxIndex = MaxIndex;
     }
     public int getMaxIndex() {
         return MaxIndex;
     }

    public void setMinIndex(int MinIndex) {
         this.MinIndex = MinIndex;
     }
     public int getMinIndex() {
         return MinIndex;
     }

}