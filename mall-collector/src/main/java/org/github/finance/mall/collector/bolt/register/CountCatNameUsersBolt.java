package org.github.finance.mall.collector.bolt.register;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import lombok.extern.slf4j.Slf4j;

/**
 * 计算各运营商人数
 * 
 * @author ligaofeng 2017年1月25日 下午12:45:29
 */
@Slf4j
public class CountCatNameUsersBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 8949683257889864224L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--21--input:{}", JSON.toJSONString(input));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
