package common;

public interface RequestParam {

    public String wxParam(String depCode, String arrCode, String depDate, String userIp, String flat, String productType);
    public String touchParam(String depCode,String arrCode,String depDate,String userIp,String flat,String productType);
    public String appParam();
    public String qqParam();
}
