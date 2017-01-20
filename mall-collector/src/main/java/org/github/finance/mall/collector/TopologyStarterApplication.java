package org.github.finance.mall.collector;

import org.github.finance.mall.collector.spout.KafkaSpout;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;

/**
 * @author ligaofeng 2017年1月19日 下午3:15:22
 */
public class TopologyStarterApplication {

    private static final String kafkaCluster    = "192.168.197.129:9092";

    private static final String consumerGroupId = "mallCollectorSpoutConsumer";

    public static void main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout(TopologyDefinition.kafkaSpoutName, new KafkaSpout(), 3);

        Config conf = new Config();
        //3个worker进程
        //Config.setNumWorkers(conf, 3);
        conf.setDebug(true);
        conf.put("kafka.consumer.timeout", "10000");
        conf.put("kafka.topics", "flume-20170101");
        conf.put("bootstrap.servers", kafkaCluster);
        //设置consumer group name,必须设置
        conf.put("group.id", consumerGroupId);
        //设置自动提交为false 采用手动提交
        conf.put("enable.auto.commit", "false");
        //设置key以及value的解析（反序列）类
        conf.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        conf.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //设置心跳时间
        conf.put("session.timeout.ms", "30000");

        StormSubmitter.submitTopology(TopologyDefinition.topologyName, conf, builder.createTopology());
    }

}
