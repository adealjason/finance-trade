package org.github.finance.mall.collector;

import java.util.Properties;

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
        Config.setNumWorkers(conf, 3);
        conf.setDebug(true);
        conf.put("kafka.consumer.timeout", 10 * 1000);
        conf.put("kafka.Props", getKafkaProps());
        conf.put("kafka.topics", "flume-20170101");

        StormSubmitter.submitTopology(TopologyDefinition.topologyName, conf, builder.createTopology());
    }

    private static Properties getKafkaProps() {
        Properties props = new Properties();
        //brokerServer(kafka)ip地址,不需要把所有集群中的地址都写上，可是一个或一部分
        props.put("bootstrap.servers", kafkaCluster);
        //设置consumer group name,必须设置
        props.put("group.id", consumerGroupId);
        //设置自动提交为false 采用手动提交
        props.put("enable.auto.commit", "false");
        //设置key以及value的解析（反序列）类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //设置心跳时间
        props.put("session.timeout.ms", "30000");
        return props;
    }

}
