package org.github.finance.mall.express.service.impl;

import org.github.finance.mall.express.dao.entity.ExpressRequestEntity;
import org.github.finance.mall.express.dao.helper.ExpressRequestEntityHelper;
import org.github.finance.mall.express.domain.ExpressDomain;
import org.github.finance.mall.express.exception.MallExpressException;
import org.github.finance.mall.express.service.IExpressRequestService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午1:27:32
 */
@Slf4j
@Service
public class ExpressRequestService implements IExpressRequestService {

    @Override
    public void saveExpressRequest(ExpressDomain expressDomain) throws MallExpressException {
        log.info("--->save express:{}", expressDomain);

        ExpressRequestEntity expressRequestEntity = ExpressRequestEntityHelper.toExpressRequestEntity(expressDomain);
        expressRequestEntity.setId(ExpressIdGenerator.generateExpressId());

        log.info("--->save expressRequestEntity:{}", expressRequestEntity);
    }

    /**
     * @author ligaofeng 2017年1月13日 下午1:52:59
     */
    private static class ExpressIdGenerator {

        private ExpressIdGenerator() {
        }

        /**
         * @return
         */
        public static String generateExpressId() {
            return String.valueOf((int) ((Math.random() * 9 + 1) * 100000000));
        }
    }

}
