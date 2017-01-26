package org.github.finance.mall.collector.bolt.order;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月26日 下午1:54:40
 */
@Slf4j
public class CacheProvinceOrderAmountBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 5948138059338922729L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--->start to cache province order amount:{}", JSON.toJSONString(input));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // do nothing
    }

}
