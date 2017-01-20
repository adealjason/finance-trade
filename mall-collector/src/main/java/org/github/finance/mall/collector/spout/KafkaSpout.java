package org.github.finance.mall.collector.spout;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import edu.emory.mathcs.backport.java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月20日 上午11:11:30
 */
@Slf4j
public class KafkaSpout extends BaseRichSpout {

    private final AtomicBoolean           closed           = new AtomicBoolean(false);

    private KafkaConsumer<String, String> consumer;

    private long                          kafkaConsumerTimeOut;

    private static final long             serialVersionUID = -4011592632161594208L;

    @SuppressWarnings("unchecked")
    @Override
    public void open(Map stormConf, TopologyContext context, SpoutOutputCollector collector) {
        Properties props = (Properties) stormConf.get("kafka.Props");
        String topicStr = (String) stormConf.get("kafka.topics");
        kafkaConsumerTimeOut = (long) stormConf.get("kafka.consumer.timeout");
        List<String> topics = (List<String>) Arrays.asList(topicStr.split(","));
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topics);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

    @Override
    public void nextTuple() {
        while (!closed.get()) {
            try {
                ConsumerRecords<String, String> records = consumer.poll(kafkaConsumerTimeOut);
                this.handleRecords(records);
                consumer.commitSync();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        log.info("--->the kafka consumer is shut down...");
    }

    private void handleRecords(ConsumerRecords<String, String> records) {
        for (ConsumerRecord<String, String> recored : records) {
            log.info("offset:{},key:{},value:{}", recored.offset(), recored.key(), recored.value());
        }
    }

    @Override
    public void close() {
        closed.set(true);
        consumer.close();
    }

}
