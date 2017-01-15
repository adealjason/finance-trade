package org.github.finance.mall.storehouse;

import org.github.finance.mall.share.storeHouse.dto.PreSaleDTO;
import org.github.finance.mall.share.storeHouse.dto.SoldDTO;
import org.github.finance.mall.storehouse.exception.MallStoreHouseException;

/**
 * @author ligaofeng 2017年1月15日 下午1:43:24
 */
public interface IStoreHourseService {

    /**
     * 预售
     * 
     * @param preSaleDTO
     * @throws MallStoreHouseException
     */
    public void preSale(PreSaleDTO preSaleDTO) throws MallStoreHouseException;

    /**
     * 已售
     * 
     * @param soldDTO
     * @throws MallStoreHouseException
     */
    public void sale(SoldDTO soldDTO) throws MallStoreHouseException;
}
