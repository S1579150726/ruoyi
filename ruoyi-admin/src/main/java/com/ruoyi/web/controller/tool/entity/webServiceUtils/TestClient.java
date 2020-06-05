/*
package com.ruoyi.web.controller.tool.entity.webServiceUtils;

import java.util.Calendar;
import java.util.Date;

public class TestClient {
    public static void main(String[] args){
        //����һ��MobileCodeWS����
        String appkey="2020185967";
        String appsecret="4AC9B48E0D3640AB9B8C035777A5AA9D";
        String time=String.valueOf(Calendar.getInstance().getTimeInMillis());
        String stringToSign = "appsecret =" + appsecret + "-time =" + time + "-method =" + "findWaterRz";
//        findWaterRz.
        String sigin=MD5Utils.MD5Upper(stringToSign);
        ZhsfService_Service zs=new ZhsfService_Service();
        ZhsfService zhsfService= zs.getZhsfServicePort();
        String resp=zhsfService.findWaterRz(appkey,time,sigin);
        System.out.println(resp);
//        findZhdt.setArg0();
//        MobileCodeWS factory = new MobileCodeWS();
//        //���ݹ�������һ��MobileCodeWSSoap����
//        MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
//        //����WebService�ṩ��getMobileCodeInfo������ѯ�ֻ�����Ĺ�����
//        String searchResult = mobileCodeWSSoap.getMobileCodeInfo("18512155752", null);
//        System.out.println(searchResult);

    }
}
*/
