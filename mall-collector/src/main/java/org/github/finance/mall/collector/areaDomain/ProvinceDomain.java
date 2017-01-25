package org.github.finance.mall.collector.areaDomain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月25日 下午6:40:32
 */
@Data
public class ProvinceDomain implements Serializable {

    private static final long serialVersionUID = 6340556710262526772L;

    private String            name;

    private String            code;

    private String            fullName;

    private String            fullCode;

    private List<CityDomain>  cities;

}
