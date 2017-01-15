package org.github.finance.mall.storehouse.impl;

import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
import org.github.finance.mall.share.storeHouse.dto.SoldDTO;
import org.github.finance.mall.storehouse.IStoreHourseService;
import org.github.finance.mall.storehouse.exception.MallStoreHouseException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月15日 下午2:02:01
 */
@Slf4j
@Service
public class StoreHourseService implements IStoreHourseService {

    @Override
    public void preSale(PreSaleDTO preSaleDTO) throws MallStoreHouseException {
        log.info("--->pre sale:{}", preSaleDTO);
    }

    @Override
    public void sale(SoldDTO soldDTO) throws MallStoreHouseException {
        log.info("--->product sold:{}", soldDTO);

    }

}
