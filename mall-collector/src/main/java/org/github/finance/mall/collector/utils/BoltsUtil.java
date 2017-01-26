package org.github.finance.mall.collector.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ligaofeng 2017年1月26日 下午1:45:20
 */
public class BoltsUtil {

    private BoltsUtil() {
    }

    /**
     * 根据手机号获取地址位置
     * 
     * @param mobile
     * @return
     */
    public static JSONObject getPsition(String mobile) {
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=%s";
        url = String.format(url, mobile);
        String getZoneResult = HttpUtils.getWithNoException(url, 10 * 1000);
        String responseJson = getZoneResult.split("=")[1].trim();
        return (JSONObject) JSON.parse(responseJson);
    }
}
