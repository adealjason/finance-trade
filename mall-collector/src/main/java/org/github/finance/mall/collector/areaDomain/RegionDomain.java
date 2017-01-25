package org.github.finance.mall.collector.areaDomain;

import java.io.Serializable;

import lombok.Data;

/**
 * @author ligaofeng 2017年1月25日 下午6:41:56
 */
@Data
public class RegionDomain implements Serializable {

    private static final long serialVersionUID = 8630795609357832045L;

    private String            name;

    private String            code;

    private String            fullName;

    private String            fullCode;

}
