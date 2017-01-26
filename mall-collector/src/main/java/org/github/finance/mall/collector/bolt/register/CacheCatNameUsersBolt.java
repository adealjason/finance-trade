package org.github.finance.mall.collector.bolt.register;

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
 * @author ligaofeng 2017年1月25日 下午8:18:31
 */
@Slf4j
public class CacheCatNameUsersBolt extends BaseBasicBolt {

    private static final long       serialVersionUID = 9196218296237335755L;

    private final IMallCacheService mallCacheService;

    public CacheCatNameUsersBolt() {
        mallCacheService = new MallCacheService();
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        log.info("--->start to cache catName users:{}", JSON.toJSONString(input));
        String fullCatNameKey = input.getString(0);
        BigDecimal cnt = (BigDecimal) input.getValue(1);
        mallCacheService.cache(fullCatNameKey, cnt);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //do nothing
    }

}
