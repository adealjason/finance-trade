package org.github.finance.mall.express.service;

import org.github.finance.mall.express.domain.ExpressDomain;
import org.github.finance.mall.express.exception.MallExpressException;

/**
 * @author ligaofeng 2017年1月15日 下午1:26:27
 */
public interface IExpressRequestService {

    /**
     * @param expressDomain
     * @throws MallExpressException
     */
    public void saveExpressRequest(ExpressDomain expressDomain) throws MallExpressException;
}
