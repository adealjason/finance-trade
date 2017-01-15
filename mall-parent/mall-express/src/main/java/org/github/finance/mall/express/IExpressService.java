package org.github.finance.mall.express;

import org.github.finance.mall.express.exception.MallExpressException;
import org.github.finance.mall.share.express.dto.CreateExpressDTO;

/**
 * @author ligaofeng 2017年1月15日 下午12:50:06
 */
public interface IExpressService {

    /**
     * 创建一笔快递
     * 
     * @param createExpressDTO
     * @throws MallExpressException
     */
    public void createExpress(CreateExpressDTO createExpressDTO) throws MallExpressException;
}
