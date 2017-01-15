package org.github.finance.mall.express.dao.helper;

import org.github.finance.mall.express.dao.entity.ExpressRequestEntity;
import org.github.finance.mall.express.domain.ExpressDomain;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月15日 下午1:31:09
 */
public class ExpressRequestEntityHelper {

    private ExpressRequestEntityHelper() {
    }

    /**
     * @param expressDomain
     * @return
     */
    public static ExpressRequestEntity toExpressRequestEntity(ExpressDomain expressDomain) {
        ExpressRequestEntity expressRequestEntity = new ExpressRequestEntity();
        expressRequestEntity.setAddress(expressDomain.getAccountAdressDomain().getAddress());
        expressRequestEntity.setAddressee(expressDomain.getAccountAdressDomain().getAddressee());
        expressRequestEntity.setAddresseePhone(expressDomain.getAccountAdressDomain().getAddresseePhone());
        expressRequestEntity.setCourierId(expressDomain.getExpressCourierDomain().getCourierId());
        expressRequestEntity.setCourierPhone(expressDomain.getExpressCourierDomain().getCourierPhone());
        expressRequestEntity.setCreator("system");
        expressRequestEntity.setExpressProviderId(expressDomain.getExpressProviderDomain().getProviderId());
        expressRequestEntity.setGmtCreated(DateTime.now().toDate());
        expressRequestEntity.setGmtModified(DateTime.now().toDate());
        expressRequestEntity.setIsDeleted("N");
        expressRequestEntity.setModifier("system");
        expressRequestEntity.setUserId(expressDomain.getUserId());
        expressRequestEntity.setUserName(expressDomain.getUserName());
        expressRequestEntity.setUserPhone(expressDomain.getUserPhone());
        expressRequestEntity.setZipCode(expressDomain.getAccountAdressDomain().getZipCode());
        return expressRequestEntity;
    }
}
