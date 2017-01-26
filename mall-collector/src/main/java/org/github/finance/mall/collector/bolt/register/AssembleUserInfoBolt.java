package org.github.finance.mall.collector.bolt.register;

import org.github.finance.mall.collector.logevent.MallRegisterEvent;
import org.github.finance.mall.collector.utils.BoltsUtil;

import com.alibaba.fastjson.JSONObject;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
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
        JSONObject jsonObject = BoltsUtil.getPsition(mallRegisterEvent.getUserPhone());
        mallRegisterEvent.setCarrier(jsonObject.getString("carrier"));
        mallRegisterEvent.setCatName(jsonObject.getString("catName"));
        mallRegisterEvent.setProvince(jsonObject.getString("province"));
        log.info("--->start to emit mallRegisterEvent:{}", mallRegisterEvent);
        //emit event
        collector.emit(new Values(mallRegisterEvent.getProvince(), mallRegisterEvent.getCatName(), mallRegisterEvent));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("province", "catName", "mallRegisterEvent"));
    }

}
