package org.github.finance.mall.collector.utils;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.github.finance.mall.collector.areaDomain.CityDomain;
import org.github.finance.mall.collector.areaDomain.CountryDomain;
import org.github.finance.mall.collector.areaDomain.ProvinceDomain;
import org.github.finance.mall.collector.areaDomain.RegionDomain;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author ligaofeng 2017年1月25日 下午6:46:01
 */
public class AreaParseor {

    private AreaParseor() {
    }

    //各地区xml文件路径
    private static final String                      LOCAL_LIST_PATH = "china.xml";
    private static final Map<String, CountryDomain>  cNameCountries  = Maps.newHashMap();
    private static final Map<String, CountryDomain>  cCodeCountries  = Maps.newHashMap();
    private static final Map<String, ProvinceDomain> cNameProvinces  = Maps.newHashMap();
    private static final Map<String, ProvinceDomain> cCodeProvinces  = Maps.newHashMap();
    private static final Map<String, CityDomain>     cNameCities     = Maps.newHashMap();
    private static final Map<String, CityDomain>     cCodeCities     = Maps.newHashMap();

    static {
        parse();
    }

    /**
     * @param provinceName
     * @return
     */
    public static ProvinceDomain searchByname(String provinceName) {
        if (MapUtils.isEmpty(cNameProvinces)) {
            return null;
        }
        for (String cName : cNameProvinces.keySet()) {
            if (provinceName.indexOf(cName) > -1) {
                return cNameProvinces.get(cName);
            }
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    private synchronized static void parse() {
        try {
            //1.读取
            SAXReader reader = new SAXReader();
            InputStream is = AreaParseor.class.getClassLoader().getResourceAsStream(LOCAL_LIST_PATH);
            Document document = reader.read(is);
            //2.获得根元素
            Element rootElement = document.getRootElement();
            //3.初始化所有国家名称列表
            Iterator it = rootElement.elementIterator();
            while (it.hasNext()) {
                CountryDomain countryDomain = parseCountry((Element) it.next());
                if (countryDomain != null) {
                    cNameCountries.put(countryDomain.getName(), countryDomain);
                    cCodeCountries.put(countryDomain.getCode(), countryDomain);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "unchecked" })
    private static CountryDomain parseCountry(Element ele) {
        CountryDomain countryDomain = new CountryDomain();
        countryDomain.setCode(ele.attributeValue("Code"));
        countryDomain.setFullCode(ele.attributeValue("Code"));
        countryDomain.setName(ele.attributeValue("Name"));
        countryDomain.setFullName(ele.attributeValue("Name"));
        List<ProvinceDomain> provinces = Lists.newArrayList();
        countryDomain.setProvinces(provinces);
        List<Element> ans = ele.elements();
        for (Element an : ans) {
            ProvinceDomain provinceDomain = parseProvince(countryDomain, an);
            if (provinceDomain != null) {
                provinces.add(provinceDomain);
                cNameProvinces.put(provinceDomain.getName(), provinceDomain);
                cCodeProvinces.put(provinceDomain.getFullCode(), provinceDomain);
            }
        }
        return countryDomain;
    }

    @SuppressWarnings("unchecked")
    private static ProvinceDomain parseProvince(CountryDomain countryDomain, Element ele) {
        ProvinceDomain provinceDomain = new ProvinceDomain();
        provinceDomain.setCode(
                StringUtils.isEmpty(ele.attributeValue("Code")) ? countryDomain.getCode() : ele.attributeValue("Code"));
        provinceDomain.setName(
                StringUtils.isEmpty(ele.attributeValue("Name")) ? countryDomain.getName() : ele.attributeValue("Name"));
        List<String> codes = Lists.newArrayList();
        codes.add(countryDomain.getFullCode());
        codes.add(provinceDomain.getCode());
        provinceDomain.setFullCode(join(codes));
        List<String> names = Lists.newArrayList();
        names.add(countryDomain.getFullName());
        names.add(provinceDomain.getName());
        provinceDomain.setFullName(join(names));
        List<CityDomain> cities = Lists.newArrayList();
        provinceDomain.setCities(cities);
        List<Element> ans = ele.elements();
        for (Element an : ans) {
            CityDomain cityDomain = parseCities(provinceDomain, an);
            if (cityDomain != null) {
                cities.add(cityDomain);
                cNameCities.put(cityDomain.getName(), cityDomain);
                cCodeCities.put(cityDomain.getFullCode(), cityDomain);
            }
        }
        return provinceDomain;
    }

    @SuppressWarnings("unchecked")
    private static CityDomain parseCities(ProvinceDomain provinceDomain, Element ele) {
        CityDomain cityDomain = new CityDomain();
        cityDomain.setCode(ele.attributeValue("Code"));
        cityDomain.setName(ele.attributeValue("Name"));
        List<String> codes = Lists.newArrayList();
        codes.add(provinceDomain.getFullCode());
        codes.add(cityDomain.getCode());
        cityDomain.setFullCode(join(codes));
        List<String> names = Lists.newArrayList();
        names.add(provinceDomain.getFullName());
        names.add(cityDomain.getName());
        cityDomain.setFullName(join(names));
        List<RegionDomain> regions = Lists.newArrayList();
        cityDomain.setRegions(regions);
        List<Element> ans = ele.elements();
        for (Element an : ans) {
            RegionDomain regionDomain = parseRegion(cityDomain, an);
            regions.add(regionDomain);
        }
        return cityDomain;
    }

    private static RegionDomain parseRegion(CityDomain cityDomain, Element ele) {
        RegionDomain regionDomain = new RegionDomain();
        regionDomain.setCode(ele.attributeValue("Code"));
        regionDomain.setName(ele.attributeValue("Name"));
        List<String> codes = Lists.newArrayList();
        codes.add(cityDomain.getFullCode());
        codes.add(regionDomain.getCode());
        regionDomain.setFullCode(join(codes));
        List<String> names = Lists.newArrayList();
        names.add(cityDomain.getFullName());
        names.add(regionDomain.getName());
        regionDomain.setFullName(join(names));
        return regionDomain;
    }

    private static String join(List<String> list) {
        return StringUtils.join(list, ".");
    }
}
