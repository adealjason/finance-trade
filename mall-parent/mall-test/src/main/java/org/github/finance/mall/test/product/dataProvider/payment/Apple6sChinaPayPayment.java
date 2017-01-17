package org.github.finance.mall.test.product.dataProvider.payment;

import org.github.finance.mall.product.domain.ProductPaymentDomain;
import org.github.finance.mall.share.payment.constance.PaymentWayEnum;
import org.github.finance.mall.test.product.dataProvider.productOffering.Apple6sProductOffering;

/**
 * @author ligaofeng 2017年1月17日 上午11:14:53
 */
public class Apple6sChinaPayPayment extends ProductPaymentDomain {

    private static final ProductPaymentDomain apple6sChinaPay = new Apple6sChinaPayPayment();

    static {
        apple6sChinaPay.setPaymentWay(PaymentWayEnum.CHINA_PAY);
        apple6sChinaPay.setProductPayentId("apple6sChinaPay");
        apple6sChinaPay.setStatus("active");
        apple6sChinaPay.setProductOfferingCode(Apple6sProductOffering.getIntance().getProductOfferingCode());
    }

    public static ProductPaymentDomain getIntance() {
        return apple6sChinaPay;
    }
}
