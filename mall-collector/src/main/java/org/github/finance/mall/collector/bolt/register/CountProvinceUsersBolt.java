package org.github.finance.mall.collector.bolt.register;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * 计算各省份人数
 * 
 * @author ligaofeng 2017年1月25日 下午12:41:47
 */
@Slf4j
public class CountProvinceUsersBolt extends BaseBasicBolt {

    private static final long serialVersionUID = -277673296319075487L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--23--input:{}", JSON.toJSONString(input));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
