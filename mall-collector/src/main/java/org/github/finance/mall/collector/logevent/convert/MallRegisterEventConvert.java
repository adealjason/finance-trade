package org.github.finance.mall.collector.logevent.convert;

import org.github.finance.mall.collector.BaseLogEvent;
import org.github.finance.mall.collector.BasicLogEventConvertSemantics;
import org.github.finance.mall.collector.logevent.MallRegisterEvent;

import com.alibaba.druid.util.StringUtils;

/**
 * 转换成注册对象
 * 
 * @author ligaofeng 2017年1月20日 下午6:18:30
 */
public class MallRegisterEventConvert extends BasicLogEventConvertSemantics {

    @Override
    public void assembleData(BaseLogEvent baseLogEvent, String otherData) {
        if (StringUtils.isEmpty(otherData)) {
            return;
        }
        MallRegisterEvent mallRegisterEvent = (MallRegisterEvent) baseLogEvent;
        String[] otherDatas = otherData.split(",");
        mallRegisterEvent.setUserId(otherDatas[0]);
        mallRegisterEvent.setUserName(otherDatas[1]);
        mallRegisterEvent.setUserPhone(otherDatas[2]);
        mallRegisterEvent.setLogInName(otherDatas[3]);
        mallRegisterEvent.setRegisterDate(otherDatas[4]);
    }

    @Override
    protected BaseLogEvent getLogEvent() {
        return new MallRegisterEvent();
    }

}
