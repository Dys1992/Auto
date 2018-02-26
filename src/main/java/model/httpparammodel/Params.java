package model.httpparammodel;

/**
 * @author fy39919
 */
public class Params {
    public String key;
    public String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(String key,StringBuilder value){

        return key+value;
    }


}
