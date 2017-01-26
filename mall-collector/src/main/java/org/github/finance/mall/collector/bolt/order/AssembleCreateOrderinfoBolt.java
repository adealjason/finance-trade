package org.github.finance.mall.collector.bolt.order;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
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
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
