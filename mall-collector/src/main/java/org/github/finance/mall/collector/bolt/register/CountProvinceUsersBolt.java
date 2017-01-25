package org.github.finance.mall.collector.bolt.register;

import org.github.finance.mall.collector.areaDomain.ProvinceDomain;
import org.github.finance.mall.collector.utils.AreaParseor;

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
        log.info("--->start to count province users:{}", JSON.toJSONString(input));
        String provinceName = input.getString(0);
        ProvinceDomain provinceDomain = AreaParseor.searchByname(provinceName);
        log.info("--->provinceDomain:{}", provinceDomain);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
