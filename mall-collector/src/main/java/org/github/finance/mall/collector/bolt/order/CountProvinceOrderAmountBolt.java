package org.github.finance.mall.collector.bolt.order;

import org.github.finance.mall.collector.RedisCacheDefinition;
import org.github.finance.mall.collector.areaDomain.ProvinceDomain;
import org.github.finance.mall.collector.logevent.CreateOrderEvent;
import org.github.finance.mall.collector.utils.AreaParseor;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月26日 下午1:50:13
 */
@Slf4j
public class CountProvinceOrderAmountBolt extends BaseBasicBolt {

    private static final long serialVersionUID = -3655357790078505494L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--->count province order amount bolt:{}", JSON.toJSONString(input));
        String provinceName = input.getString(0);
        CreateOrderEvent createOrderEvent = (CreateOrderEvent) input.getValue(1);
        ProvinceDomain provinceDomain = AreaParseor.searchByname(provinceName);
        String fullCode = RedisCacheDefinition.unkown;
        if (provinceDomain != null) {
            fullCode = provinceDomain.getFullCode();
        }
        String provinceOrderAmountKey = RedisCacheDefinition.provinceOrderAmountPrefix.concat(".").concat(fullCode);
        collector.emit(new Values(provinceOrderAmountKey, createOrderEvent.getOrderAmount()));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("provinceOrderAmountKey", "orderAmount"));
    }

}
