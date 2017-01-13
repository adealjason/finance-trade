package org.github.finance.mall.payment.dao.helper;

import org.github.finance.mall.payment.constance.PaymentStatusEnum;
import org.github.finance.mall.payment.dao.dataobject.PaymentRequestDO;
import org.github.finance.mall.payment.dto.CreatePaymentDTO;
import org.joda.time.DateTime;

/**
 * @author ligaofeng 2017年1月13日 下午2:05:03
 */
public class PaymentRequestDOHelper {

    private PaymentRequestDOHelper() {
    }

    /**
     * @param createPaymentDTO
     * @return
     */
    public static PaymentRequestDO toCreatePaymentRequestDO(CreatePaymentDTO createPaymentDTO) {
        DateTime now = DateTime.now();
        PaymentRequestDO paymentRequestDO = new PaymentRequestDO();
        paymentRequestDO.setIsDeleted("N");
        paymentRequestDO.setModifier("system");
        paymentRequestDO.setCreator("system");
        paymentRequestDO.setGmtCreated(now.toDate());
        paymentRequestDO.setGmtModified(now.toDate());
        paymentRequestDO.setOrderId(createPaymentDTO.getOrderId());
        paymentRequestDO.setPaymentAmount(createPaymentDTO.getPaymentAmount());
        paymentRequestDO.setProductOfferingCode(createPaymentDTO.getProductOfferingCode());
        paymentRequestDO.setUserId(createPaymentDTO.getUserId());
        paymentRequestDO.setPaymentStatus(PaymentStatusEnum.PAYMENT_WAIT.name());
        return paymentRequestDO;
    }

}
