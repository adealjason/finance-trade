package org.github.finance.mall.collector.bolt.register;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月25日 下午8:08:44
 */
@Slf4j
public class CacheProvinceUsersBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 7256764867131120543L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--->start to cache province users:{}", JSON.toJSONString(input));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //do nothing
    }

}
