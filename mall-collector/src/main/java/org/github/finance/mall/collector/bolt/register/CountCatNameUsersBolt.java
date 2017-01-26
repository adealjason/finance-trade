package org.github.finance.mall.collector.bolt.register;

import org.apache.commons.lang.StringUtils;
import org.github.finance.mall.collector.RedisCacheDefinition;
import org.github.finance.mall.collector.utils.CatNameUtil;

import com.alibaba.fastjson.JSON;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
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
        log.info("--->start to count catName users:{}", JSON.toJSONString(input));
        String catName = input.getString(1);
        String catNamekey = RedisCacheDefinition.unkown;
        String tmp = CatNameUtil.searchByName(catName);
        if (StringUtils.isNotEmpty(tmp)) {
            catNamekey = tmp;
        }
        String fullCatNameKey = RedisCacheDefinition.catNameUsersCntPrefix.concat(".").concat(catNamekey);
        collector.emit(new Values(fullCatNameKey, 1));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("fullCatNameKey", "cnt"));
    }

}
