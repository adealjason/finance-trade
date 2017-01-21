package org.github.finance.mall.collector.bolt.register;

import org.github.finance.mall.collector.logevent.MallRegisterEvent;
import org.github.finance.mall.collector.utils.HttpUtils;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * 填充用户的个人信息
 * 
 * @author ligaofeng 2017年1月21日 上午10:36:20
 */
@Slf4j
public class AssembleUserInfoBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 8659042647948428127L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        String collectEvent = input.getString(0);
        MallRegisterEvent mallRegisterEvent = (MallRegisterEvent) input.getValue(1);
        log.info("--->deal event {},start to assemble user info:{}", collectEvent, mallRegisterEvent);
        log.info(this.getPsition(mallRegisterEvent.getUserPhone()));
    }

    private String getPsition(String mobile) {
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=%s";
        url = String.format(url, mobile);
        return HttpUtils.getWithNoException(url, 10 * 1000);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
