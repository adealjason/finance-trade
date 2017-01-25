package org.github.finance.mall.collector.areaDomain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月25日 下午6:40:57
 */
@Data
public class CityDomain implements Serializable {

    private static final long  serialVersionUID = 3760676683994796215L;

    private String             name;

    private String             code;

    private String             fullName;

    private String             fullCode;

    private List<RegionDomain> regions;

}
