package org.github.finance.mall.collector.utils;

import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.google.common.collect.Maps;

/**
 * @author ligaofeng 2017年1月25日 下午8:19:44
 */
public class CatNameUtil {

    private CatNameUtil() {
    }

    private static final Map<String, String> catNames = Maps.newHashMap();

    static {
        catNames.put("电信", "10000");
        catNames.put("移动", "10086");
        catNames.put("联通", "10010");
    }

    /**
     * @param catName
     * @return
     */
    public static String searchByName(String catName) {
        if (MapUtils.isEmpty(catNames)) {
            return null;
        }
        for (String cName : catNames.keySet()) {
            if (catName.indexOf(cName) > -1) {
                return catNames.get(cName);
            }
        }
        return null;
    }
}
