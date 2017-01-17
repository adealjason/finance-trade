package org.github.finance.mall.bank.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.github.finance.common.logevent.DataCollector;
import org.github.finance.common.logevent.DataCollector.DataCollectorProvider;
import org.github.finance.mall.bank.IBankService;
import org.github.finance.mall.bank.domain.BankAccountDomain;
import org.github.finance.mall.bank.domain.helper.BankAccountDomainHelper;
import org.github.finance.mall.bank.exception.MallBankException;
import org.github.finance.mall.bank.service.IBankAccountService;
import org.github.finance.mall.share.bank.constance.BankAccountLogEvent;
import org.github.finance.mall.share.bank.constance.BindCardStatusEnum;
import org.github.finance.mall.share.bank.dto.BindCardDTO;
import org.github.finance.mall.share.bank.dto.ChangeBankPhoneDTO;
import org.github.finance.mall.share.bank.dto.UnBindCardDTO;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月12日 下午7:36:45
 */
@Slf4j
@Service
public class BankService implements IBankService {

    @Resource
    private IBankAccountService bankAccountService;
    @Resource
    private DataCollector       bankAccountEventLogCollector;

    @Override
    public void bindCard(final BindCardDTO bindCardDTO) throws MallBankException {
        log.info("--->user {} will to bind card {}", bindCardDTO.getUserId(), bindCardDTO.getCardNo());

        log.info("--->check whether the card is binded...");

        log.info("--->check the card through the bank...");

        log.info("--->bind card success,save the recored...");

        BankAccountDomain bankAccountDomain = BankAccountDomainHelper.toBankAccountDomain(bindCardDTO);
        this.assembleBindCardInfo(bankAccountDomain);
        bankAccountService.saveBankAccount(bankAccountDomain);

        bankAccountEventLogCollector.collectData(new DataCollectorProvider() {
            @Override
            public Map<String, String> getMetaData() {
                Map<String, String> dataMap = Maps.newHashMap();
                dataMap.put("userId", bindCardDTO.getUserId());
                dataMap.put("bindCardDate", String.valueOf(DateTime.now().toDate().getTime()));
                return dataMap;
            }

            @Override
            public String getLogEvent() {
                return BankAccountLogEvent.BIND_CARD.name();
            }
        });
    }

    private void assembleBindCardInfo(BankAccountDomain bankAccountDomain) {
        log.info("--->assemble bind card info:{}", bankAccountDomain);
        bankAccountDomain.setStatus(BindCardStatusEnum.BIND);
        bankAccountDomain.setBankName(BankConstrol.getBankName(bankAccountDomain.getCardNo()));
    }

    @Override
    public void unBindCard(final UnBindCardDTO unBindCardDTO) throws MallBankException {

        log.info("--->unBindCard cast to BankAccountDomain by unBindCardDTO:{}", unBindCardDTO);
        BankAccountDomain bankAccountDomain = BankAccountDomainHelper.toBankAccountDomain(unBindCardDTO);
        bankAccountDomain.setStatus(BindCardStatusEnum.UNBIND);
        bankAccountService.updateBankAccount(bankAccountDomain);
        bankAccountEventLogCollector.collectData(new DataCollectorProvider() {
            @Override
            public Map<String, String> getMetaData() {
                Map<String, String> dataMap = Maps.newHashMap();
                dataMap.put("userId", unBindCardDTO.getUserId());
                dataMap.put("bindCardDate", String.valueOf(DateTime.now().toDate().getTime()));
                return dataMap;
            }

            @Override
            public String getLogEvent() {
                return BankAccountLogEvent.UNBIND.name();
            }
        });
    }

    @Override
    public void changeBankPhone(ChangeBankPhoneDTO changeBankPhoneDTO) throws MallBankException {

        log.info("--->changeBankPhone validate the sourceBankPhone...");

        log.info("--->cast to BankAccountDomain by changeBankPhoneDTO:{}", changeBankPhoneDTO);
        BankAccountDomain bankAccountDomain = BankAccountDomainHelper.toBankAccountDomain(changeBankPhoneDTO);
        bankAccountService.updateBankAccount(bankAccountDomain);
    }

    /**
     * @author ligaofeng 2017年1月12日 下午8:37:19
     */
    private static class BankConstrol {

        /**
         * 根据卡号获取银行名称
         * 
         * @param cardNo
         * @return
         */
        public static String getBankName(String cardNo) {
            return "ICBC";
        }
    }
}
