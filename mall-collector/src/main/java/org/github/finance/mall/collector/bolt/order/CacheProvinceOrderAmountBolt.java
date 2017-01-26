package org.github.finance.mall.collector.bolt.order;

import java.math.BigDecimal;

import org.github.finance.mall.collector.service.IMallCacheService;
import org.github.finance.mall.collector.service.impl.MallCacheService;

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

    private static final long       serialVersionUID = 5948138059338922729L;

    private final IMallCacheService mallCacheService;

    public CacheProvinceOrderAmountBolt() {
        mallCacheService = new MallCacheService();
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--->start to cache province order amount:{}", JSON.toJSONString(input));
        String provinceOrderAmountKey = input.getString(0);
        BigDecimal orderAmount = (BigDecimal) input.getValue(1);
        mallCacheService.cache(provinceOrderAmountKey, orderAmount);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // do nothing
    }

}
