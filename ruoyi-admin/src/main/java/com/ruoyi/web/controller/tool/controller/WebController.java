package com.ruoyi.web.controller.tool.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.tool.entity.webServiceUtils.FindAreaCount;
import com.ruoyi.web.controller.tool.entity.webServiceUtils.GetAuthParams;
import com.ruoyi.web.controller.tool.entity.webServiceUtils.ZhsfService;
import com.ruoyi.web.controller.tool.entity.webServiceUtils.ZhsfService_Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.EAN;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "大屏接口管理之findWaterRz")
@RestController
@RequestMapping("/system/find")
public class WebController extends BaseController {
    private GetAuthParams getAuthParams;
    private static ZhsfService_Service zhsfService_Service=new ZhsfService_Service();
    private static ZhsfService zhsfServicePort=zhsfService_Service.getZhsfServicePort();
    @ApiOperation("左屏：统计水库、河道、积涝点水位预警数目")
    @GetMapping("/findWaterAlwtlv")
    public AjaxResult cfindWaterAlwtlv(){
        getAuthParams = new GetAuthParams("findWaterAlwtlv");
        String waterAlwtlv = zhsfServicePort.findWaterAlwtlv(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String tp = jsonObject1.getString("TP");
            Integer sl = jsonObject1.getInteger("SL");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("TP",tp);
            map.put("SL",sl);
            objects.add(map);
        }
       if (result!=null&&result.size()>0){
           return AjaxResult.success("查询成功",objects);
       }
       return AjaxResult.error("查询失败");
    }
    @ApiOperation("应急信息")
    @GetMapping("/findAreaCount")
    public AjaxResult cfindAreaCount(){
        GetAuthParams getAuthParams1 = new GetAuthParams("findAreaCount");
        String waterAlwtlv = zhsfServicePort.findAreaCount(getAuthParams1.appkey, getAuthParams1.time, getAuthParams1.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("DSNM","光明区");
        map1.put("PNUM",0);
        Map<Object, Object> map2 = new HashMap<>();
        map2.put("DSNM","宝安区");
        map2.put("PNUM",0);
        Map<Object, Object> map3 = new HashMap<>();
        map3.put("DSNM","龙华区");
        map3.put("PNUM",0);
        Map<Object, Object> map4 = new HashMap<>();
        map4.put("DSNM","南山区");
        map4.put("PNUM",0);
        Map<Object, Object> map5 = new HashMap<>();
        map5.put("DSNM","福田区");
        map5.put("PNUM",0);
        Map<Object, Object> map6 = new HashMap<>();
        map6.put("DSNM2","罗湖区");
        map6.put("PNUM",0);
        Map<Object, Object> map7 = new HashMap<>();
        map7.put("DSNM","盐田区");
        map7.put("PNUM",0);
        Map<Object, Object> map8 = new HashMap<>();
        map8.put("DSNM","龙岗区");
        map8.put("PNUM",0);
        Map<Object, Object> map9 = new HashMap<>();
        map9.put("DSNM","坪山区");
        map9.put("PNUM",0);
        Map<Object, Object> map10 = new HashMap<>();
        map10.put("DSNM","大鹏新区");
        map10.put("PNUM",0);
        Map<Object, Object> map11 = new HashMap<>();
        map11.put("DSNM","深汕合作区");
        map11.put("PNUM",0);
        for (int i=0;i<result.size();i++){
            HashMap<Object, Object> map = new HashMap<>();
            JSONObject jsonObject1 = result.getJSONObject(i);
            String dsnm = jsonObject1.getString("DSNM");
            Integer ck = jsonObject1.getInteger("CK");
            Integer bncssl = jsonObject1.getInteger("BNCSSL");
            Integer qxdw = jsonObject1.getInteger("QXDW");
            if (dsnm != null && dsnm.equals("光明区")) {
                map1.put("CK",ck);
                map1.put("BNCSSL",bncssl);
                map1.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("宝安区")) {
                map2.put("CK",ck);
                map2.put("BNCSSL",bncssl);
                map2.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("龙华区")) {
                map3.put("CK",ck);
                map3.put("BNCSSL",bncssl);
                map3.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("南山区")) {
                map4.put("CK",ck);
                map4.put("BNCSSL",bncssl);
                map4.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("福田区")) {
                map5.put("CK",ck);
                map5.put("BNCSSL",bncssl);
                map5.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("罗湖区")) {
                map6.put("CK",ck);
                map6.put("BNCSSL",bncssl);
                map6.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("盐田区")) {
                map7.put("CK",ck);
                map7.put("BNCSSL",bncssl);
                map7.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("龙岗区")) {
                map8.put("CK",ck);
                map8.put("BNCSSL",bncssl);
                map8.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("坪山区")) {
                map9.put("CK",ck);
                map9.put("BNCSSL",bncssl);
                map9.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("大鹏新区")) {
                map10.put("CK",ck);
                map10.put("BNCSSL",bncssl);
                map10.put("QXDW",qxdw);
            } else if (dsnm != null && dsnm.equals("深汕合作区")) {
                map11.put("CK",ck);
                map11.put("BNCSSL",bncssl);
                map11.put("QXDW",qxdw);
            }
        }
        GetAuthParams getAuthParams = new GetAuthParams("findErnyctrinf");
        String ernyctrinf = zhsfServicePort.findErnyctrinf(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject3 = JSON.parseObject(ernyctrinf);
        JSONArray result3 = jsonObject3.getJSONArray("RESULT");
        for (int j=0;j<result3.size();j++) {
            JSONObject jsonObject2 = result3.getJSONObject(j);
            String dsnm = jsonObject2.getString("DSNM");
            if (dsnm != null && dsnm.equals("光明区")) {
                map1.put("PNUM", (Integer) map1.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("宝安区")) {
                map2.put("PNUM", (Integer) map2.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("龙华区")) {
                map3.put("PNUM", (Integer) map3.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("南山区")) {
                map4.put("PNUM", (Integer) map4.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("福田区")) {
                map5.put("PNUM", (Integer) map5.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("罗湖区")) {
                map6.put("PNUM", (Integer) map6.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("盐田区")) {
                map7.put("PNUM", (Integer) map7.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("龙岗区")) {
                map8.put("PNUM", (Integer) map8.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("坪山区")) {
                map9.put("PNUM", (Integer) map9.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("大鹏新区")) {
                map10.put("PNUM", (Integer) map10.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("深汕合作区")) {
                map11.put("PNUM", (Integer) map11.get("PNUM") + 1);
            }
        }
        objects.add(map1);
        objects.add(map2);
        objects.add(map3);
        objects.add(map4);
        objects.add(map5);
        objects.add(map6);
        objects.add(map7);
        objects.add(map8);
        objects.add(map9);
        objects.add(map10);
        objects.add(map11);

        if (objects!=null&&objects.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("左屏：按水库工程等级大中型、小（1）、小（2）型统计水位，包括正常、开放式溢洪道溢流、超汛限")
    @GetMapping("/findWaterRz")
    public AjaxResult cfindWaterRz(){
        getAuthParams = new GetAuthParams("findWaterRz");
        String waterAlwtlv = zhsfServicePort.findWaterRz(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        Map map=new HashMap();
        map.put("TP","水库水位");
        map.put("ZCSL",0);
        map.put("CXQSL",0);
        Map map2=new HashMap();
        map2.put("TP","河道水位");
        map2.put("ZCSL",0);
        map2.put("CXQSL",0);
        Map map3=new HashMap();
        map3.put("TP","积涝点水位");
        map3.put("ZCSL",0);
        map3.put("CXQSL",0);
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String tp = jsonObject1.getString("TP");

            Float xxsw = jsonObject1.getFloat("XXSW");
            String xfcxx = jsonObject1.getString("XFCXX");
            if (tp!=null&&tp.equals("水库")){
                if (xfcxx!=null&&xfcxx.equals("否")){
                    map.put("ZCSL",(Integer)map.get("ZCSL")+1);
                }else{
                    map.put("CXQSL",(Integer)map.get("CXQSL")+1);
                }
            }else if (tp!=null&&tp.equals("河道")){
                if (xfcxx!=null&&xfcxx.equals("否")){
                    map2.put("ZCSL",(Integer)map2.get("ZCSL")+1);
                }else{
                    map2.put("CXQSL",(Integer)map2.get("CXQSL")+1);
                }
            }if (tp!=null&&tp.equals("积水")){
                if (xfcxx!=null&&xfcxx.equals("否")){
                    map3.put("ZCSL",(Integer)map3.get("ZCSL")+1);
                }else{
                    map3.put("CXQSL",(Integer)map3.get("CXQSL")+1);
                }
            }
        }
        objects.add(map);
        objects.add(map2);
        objects.add(map3);
        if (objects!=null&&objects.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }



    @ApiOperation("左屏：统计负责人人数")
    @GetMapping("/findErnyctrinf")
    public AjaxResult cfindErnyctrinf(){
        GetAuthParams getAuthParams = new GetAuthParams("findErnyctrinf");
        String ernyctrinf = zhsfServicePort.findErnyctrinf(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(ernyctrinf);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("DSNM","光明区");
        map1.put("PNUM",0);
        Map<Object, Object> map2 = new HashMap<>();
        map2.put("DSNM","宝安区");
        map2.put("PNUM",0);
        Map<Object, Object> map3 = new HashMap<>();
        map3.put("DSNM","龙华区");
        map3.put("PNUM",0);
       Map<Object, Object> map4 = new HashMap<>();
        map4.put("DSNM","南山区");
        map4.put("PNUM",0);
        Map<Object, Object> map5 = new HashMap<>();
        map5.put("DSNM","福田区");
        map5.put("PNUM",0);
        Map<Object, Object> map6 = new HashMap<>();
        map6.put("DSNM","罗湖区");
        map6.put("PNUM",0);
        Map<Object, Object> map7 = new HashMap<>();
        map7.put("DSNM","盐田区");
        map7.put("PNUM",0);
        Map<Object, Object> map8 = new HashMap<>();
        map8.put("DSNM","龙岗区");
        map8.put("PNUM",0);
       Map<Object, Object> map9 = new HashMap<>();
        map9.put("DSNM","坪山区");
        map9.put("PNUM",0);
        Map<Object, Object> map10 = new HashMap<>();
        map10.put("DSNM","大鹏新区");
        map10.put("PNUM",0);
        Map<Object, Object> map11 = new HashMap<>();
        map11.put("DSNM","深汕合作区");
        map11.put("PNUM",0);
        for (int j=0;j<result.size();j++) {
            JSONObject jsonObject2 = result.getJSONObject(j);
            String dsnm = jsonObject2.getString("DSNM");
            if (dsnm != null && dsnm.equals("光明区")) {
                map1.put("PNUM", (Integer) map1.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("宝安区")) {
                map2.put("PNUM", (Integer) map2.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("龙华区")) {
                map3.put("PNUM", (Integer) map3.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("南山区")) {
                map4.put("PNUM", (Integer) map4.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("福田区")) {
                map5.put("PNUM", (Integer) map5.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("罗湖区")) {
                map6.put("PNUM", (Integer) map6.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("盐田区")) {
                map7.put("PNUM", (Integer) map7.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("龙岗区")) {
                map8.put("PNUM", (Integer) map8.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("坪山区")) {
                map9.put("PNUM", (Integer) map9.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("大鹏新区")) {
                map10.put("PNUM", (Integer) map10.get("PNUM") + 1);
            } else if (dsnm != null && dsnm.equals("深汕合作区")) {
                map11.put("PNUM", (Integer) map11.get("PNUM") + 1);
            }
        }
            objects.add(map1);
            objects.add(map2);
            objects.add(map3);
            objects.add(map4);
            objects.add(map5);
            objects.add(map6);
            objects.add(map7);
            objects.add(map8);
            objects.add(map9);
            objects.add(map10);
            objects.add(map11);

        if (objects!=null&&objects.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }


    @ApiOperation("中屏：名称、类型、坐标")
    @GetMapping("/findZdfyfxd")
    public AjaxResult cfindZdfyfxd(){
        getAuthParams = new GetAuthParams("findZdfyfxd");
        String waterAlwtlv = zhsfServicePort.findZdfyfxd(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }
    /*
    * */
    @ApiOperation("中屏：名称、类型、坐标(经度，纬度)，区划")
    @GetMapping("/findZdfhdx")
    public AjaxResult cfindZdfhdx(){
        getAuthParams = new GetAuthParams("findZdfhdx");
        String waterAlwtlv = zhsfServicePort.findZdfhdx(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        System.out.println(result);
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }
    @ApiOperation("中屏：名称、监测水位、警戒水位、监测时间")
    @GetMapping("/findWaterRz3")
    public AjaxResult cfindWaterRz3(){
        getAuthParams = new GetAuthParams("findWaterRz");
        String waterAlwtlv = zhsfServicePort.findWaterRz(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String ly = jsonObject1.getString("大鹏湾水系");
            String tm = jsonObject1.getString("TM");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("ly",ly);
            map.put("TM",tm);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }
    @ApiOperation("中屏：名称、监测水位、警戒水位、监测时间、所属区划、测站状态")
    @GetMapping("/findWaterRz4")
    public AjaxResult cfindWaterRz4(){
        getAuthParams = new GetAuthParams("findWaterRz");
        String waterAlwtlv = zhsfServicePort.findWaterRz(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }
    @ApiOperation("中屏：名称、监测水位、监测时间、测站状态、汛限水位、距汛限水位、校核洪水位、" +
            "死水位、总库容（万m³）、溢洪道型式、消能方式、水库目前功能、所属区划、行政责任人姓名、" +
            "行政责任人职务、行政责任人电话、技术负责人姓名、技术负责人职务、技术负责人电话")
    @GetMapping("/findWaterRz5")
    public AjaxResult cfindWaterRz5(){
        getAuthParams = new GetAuthParams("findWaterRz");
        String waterAlwtlv = zhsfServicePort.findWaterRz(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            Float rz = jsonObject1.getFloat("RZ");
            Float xxsw = jsonObject1.getFloat("XXSW");
            String tm = jsonObject1.getString("TM");
            String qh = jsonObject1.getString("QH");
            String xfcxx = jsonObject1.getString("XFCXX");
            String tp = jsonObject1.getString("TP");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("RZ",rz);
            map.put("XXSW",xxsw);
            map.put("TM",tm);
            map.put("QH",qh);
            map.put("XFCXX",xfcxx);
            map.put("TP",tp);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }
    @ApiOperation("中屏：仓库名称、所在区域、联系人、联系电话、规模（面积）、地址")
    @GetMapping("/findStore")
    public AjaxResult cfindStore(){
        getAuthParams = new GetAuthParams("findStore");
        String waterAlwtlv = zhsfServicePort.findStore(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String dsnm = jsonObject1.getString("DSNM");
            String name = jsonObject1.getString("NAME");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("DSNM",dsnm);
            map.put("NAME",name);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }
    @ApiOperation("中屏：名称、责任人、责任人电话、所能容纳人数、是否开发、所属区域、具体地址")
    @GetMapping("/findErnyctrinf1")
    public AjaxResult cfindErnyctrinf1(){
        getAuthParams = new GetAuthParams("findErnyctrinf");
        String waterAlwtlv = zhsfServicePort.findErnyctrinf(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String dsnm = jsonObject1.getString("DSNM");
            String eRNYCTLKN = jsonObject1.getString("ERNYCTLKN");
            String ernyctnmb = jsonObject1.getString("ERNYCTNMB");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("ERNYCTLKN",eRNYCTLKN);
            map.put("DSNM",dsnm);
            map.put("ERNYCTNMB",ernyctnmb);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }
    @ApiOperation("中屏地图：名称、街道、威胁对象、威胁人数、潜在经济损失（万元）、" +
            "隐患等级、监测预防责任单位、预防联系人、联系电话、治理责任单位、行业监管部门")
    @GetMapping("/findDzzhyhd")
    public AjaxResult cfindDzzhyhd(){
        getAuthParams = new GetAuthParams("findDzzhyhd");
        String waterAlwtlv = zhsfServicePort.findDzzhyhd(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("中屏地图：名称、编码、所属行政区、工程等级、建成日期（年月）、设计洪水位（m）、校核水位（m）、" +
            "正常蓄水位（m）、防汛水位（m）、死水位（m）、总库容（万m³）、正常库容（万m³）")
    @GetMapping("/findReservoir")
    public AjaxResult cfindReservoir(){
        getAuthParams = new GetAuthParams("findReservoir");
        String waterAlwtlv = zhsfServicePort.findReservoir(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("中屏地图：名称、编码、级别、所属干流、流域面积（k㎡）、河道长度（km）、所属区划、所属流域")
    @GetMapping("/findRiver")
    public AjaxResult cfindRiver(){
        getAuthParams = new GetAuthParams("findRiver");
        String waterAlwtlv = zhsfServicePort.findRiver(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("中屏地图：名称、编码、点位海堤高程（m）、点位防浪墙顶高程（m）")
    @GetMapping("/findSeawall")
    public AjaxResult cfindSeawall(){
        getAuthParams = new GetAuthParams("findSeawall");
        String waterAlwtlv = zhsfServicePort.findSeawall(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("中屏地图：名称、建成时间、所在河道、行政区、街道办、设计标准（年）、" +
            "闸孔数量（孔）、闸顶高程（m）、过闸流量（m³/s）、水闸型及启闭方式、经度、纬度")
    @GetMapping("/findWatergate")
    public AjaxResult cfindWatergate(){
        getAuthParams = new GetAuthParams("findWatergate");
        String waterAlwtlv = zhsfServicePort.findWatergate(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("中屏地图：名称、外排河道名称、泵站规模、装机总功率（KW）、设计抽排流量（万m³/d）、" +
            "设计扬程（m）、水泵台数、进水池最高水位（m）、进水池最低水位（m）、管理单位名称")
    @GetMapping("/findPump")
    public AjaxResult cfindPump(){
        getAuthParams = new GetAuthParams("findPump");
        String waterAlwtlv = zhsfServicePort.findPump(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }



    @ApiOperation("右屏：按类型、所属行政区划统计")
    @GetMapping("/findZdfhdxCount")
    public AjaxResult cfindZdfhdxCount(){
        getAuthParams = new GetAuthParams("findZdfhdxCount");
        String waterAlwtlv = zhsfServicePort.findZdfhdxCount(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("右屏：1、按所属行政区划统计应急避难场所数量；\n" +
            "2、按所属行政区划统计容纳人数；")
    @GetMapping("/findAreaCount2")
    public AjaxResult cfindAreaCount2(){
        getAuthParams = new GetAuthParams("findAreaCount");
        String waterAlwtlv = zhsfServicePort.findAreaCount(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String dsnm = jsonObject1.getString("DSNM");
            Integer bncsSL = jsonObject1.getInteger("BNCSSL");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("DSNM",dsnm);
            map.put("BNCSSL",bncsSL);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("右屏：1、按所属行政区划统计三防仓库数量；\n" +
            "2、按所属行政区划统计大流量移动泵数量；\n" +
            "3、按所属行政区划统计发电设备数量；\n" +
            "4、按所属行政区划统计救生船艇数量；")
    @GetMapping("/findAreaCount3")
    public AjaxResult cfindAreaCount3(){
        getAuthParams = new GetAuthParams("findAreaCount");
        String waterAlwtlv = zhsfServicePort.findAreaCount(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String dsnm = jsonObject1.getString("DSNM");
            Integer ck = jsonObject1.getInteger("CK");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("DSNM",dsnm);
            map.put("CK",ck);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("右屏：按所属行政区划统计风险点")
    @GetMapping("/findAreaCount4")
    public AjaxResult cfindAreaCount4(){
        getAuthParams = new GetAuthParams("findAreaCount");
        String waterAlwtlv = zhsfServicePort.findAreaCount(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("右屏：1、按所属行政区划统计水库数量；\n" +
            "2、按所属行政区划统计河道数量；\n" +
            "3、按所属行政区划统计海堤数量；\n" +
            "4、按所属行政区划统计水闸数量；\n" +
            "5、按所属行政区划统计排水泵站数量；")
    @GetMapping("/findAreaCount5")
    public AjaxResult cfindAreaCount5(){
        getAuthParams = new GetAuthParams("findAreaCount");
        String waterAlwtlv = zhsfServicePort.findAreaCount(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",result);
        }
        return AjaxResult.error("查询失败");
    }

    @ApiOperation("右屏：1、按所属行政区划统计抢险队伍数量；")
    @GetMapping("/findAreaCount6")
    public AjaxResult cfindAreaCount6(){
        getAuthParams = new GetAuthParams("findAreaCount");
        String waterAlwtlv = zhsfServicePort.findAreaCount(getAuthParams.appkey, getAuthParams.time, getAuthParams.sigin);
        JSONObject jsonObject = JSON.parseObject(waterAlwtlv);
        JSONArray result = jsonObject.getJSONArray("RESULT");
        JSONArray objects = new JSONArray();
        for (int i=0;i<result.size();i++){
            JSONObject jsonObject1 = result.getJSONObject(i);
            String dsnm = jsonObject1.getString("DSNM");
            Integer qxdw = jsonObject1.getInteger("QXDW");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("DSNM",dsnm);
            map.put("QXDW",qxdw);
            objects.add(map);
        }
        if (result!=null&&result.size()>0){
            return AjaxResult.success("查询成功",objects);
        }
        return AjaxResult.error("查询失败");
    }

}
