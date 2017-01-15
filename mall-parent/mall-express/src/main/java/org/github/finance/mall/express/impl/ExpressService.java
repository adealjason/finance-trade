package org.github.finance.mall.express.impl;

import org.github.finance.mall.express.IExpressService;
import org.github.finance.mall.express.domain.ExpressDomain;
import org.github.finance.mall.express.domain.helper.ExpressDomainHelper;
import org.github.finance.mall.express.exception.MallExpressException;
import org.github.finance.mall.share.express.dto.CreateExpressDTO;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午1:18:41
 */
@Slf4j
@Service
public class ExpressService implements IExpressService {

    @Override
    public void createExpress(CreateExpressDTO createExpressDTO) throws MallExpressException {
        log.info("--->will create express:{}", createExpressDTO);
        ExpressDomain expressDomain = ExpressDomainHelper.toExpressDomain(createExpressDTO);
    }

}
