package com.ruoyi.web.controller.tool.entity.webServiceUtils;

import java.util.Calendar;

public class GetAuthParams {
    public static String appkey="2020185967";
    public static String appsecret="4AC9B48E0D3640AB9B8C035777A5AA9D";
    public static String stringToSign;
    public static String methodName;
    public static String sigin;
    public String time;
    public GetAuthParams(String name){
        this.methodName=name;
        this.time=String.valueOf(Calendar.getInstance().getTimeInMillis());
        this.stringToSign= "appsecret =" + appsecret + "-time =" + time + "-method =" + methodName;
        this.sigin=MD5Utils.MD5Upper(stringToSign);
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
