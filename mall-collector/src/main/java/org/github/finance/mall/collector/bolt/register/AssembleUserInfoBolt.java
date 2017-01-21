package org.github.finance.mall.collector.bolt.register;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

/**
 * 填充用户的个人信息
 * 
 * @author ligaofeng 2017年1月21日 上午10:36:20
 */
public class AssembleUserInfoBolt extends BaseBasicBolt {

    private static final long serialVersionUID = 8659042647948428127L;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        // TODO Auto-generated method stub

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // TODO Auto-generated method stub

    }

}
