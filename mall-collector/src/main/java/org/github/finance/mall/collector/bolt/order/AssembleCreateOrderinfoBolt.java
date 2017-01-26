package org.github.finance.mall.collector.bolt.order;

import org.github.finance.mall.collector.logevent.CreateOrderEvent;
import org.github.finance.mall.collector.utils.BoltsUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月26日 下午1:06:42
 */
@Slf4j
public class AssembleCreateOrderinfoBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 1492265990486614883L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--->assemble createOrder info bolt:{}", JSON.toJSONString(input));
        CreateOrderEvent createOrderEvent = (CreateOrderEvent) input.getValue(1);
        JSONObject jsonObject = BoltsUtil.getPsition(createOrderEvent.getUserPhone());
        createOrderEvent.setProvince(jsonObject.getString("province"));
        collector.emit(new Values(createOrderEvent.getProvince(), createOrderEvent));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("province", "createOrderEvent"));
    }

}
