package org.github.finance.mall.collector.spout;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.github.finance.mall.collector.BaseLogEvent;
import org.github.finance.mall.collector.CollectEvent;
import org.github.finance.mall.collector.ILogEventConvert;
import org.github.finance.mall.collector.logevent.LogEventUtils;
import org.github.finance.mall.collector.logevent.MallRegisterEvent;

import com.alibaba.druid.util.StringUtils;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ligaofeng 2017年1月20日 上午11:11:30
 */
@Slf4j
public class KafkaSpout extends BaseRichSpout {

    private final AtomicBoolean           closed           = new AtomicBoolean(false);
    private KafkaConsumer<String, String> consumer;
    private SpoutOutputCollector          collector;
    private long                          kafkaConsumerTimeOut;
    private static final long             serialVersionUID = -4011592632161594208L;

    @SuppressWarnings({ "rawtypes" })
    @Override
    public void open(Map stormConf, TopologyContext context, SpoutOutputCollector collector) {
        log.info("stormConf:{}", stormConf);
        this.collector = collector;
        kafkaConsumerTimeOut = Long.valueOf(String.valueOf(stormConf.get("kafka.consumer.timeout")));
        String topicStr = String.valueOf(stormConf.get("kafka.topics"));
        List<String> topics = Arrays.asList(topicStr.split(","));
        Properties props = this.getKafkaProps(stormConf);
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topics);
        log.info("--->kafka consumer started...");
    }

    @SuppressWarnings("rawtypes")
    private Properties getKafkaProps(Map stormConf) {
        String bootstrapServers = String.valueOf(stormConf.get("bootstrap.servers"));
        String consumerGroupId = String.valueOf(stormConf.get("group.id"));
        String enableAutoCommit = String.valueOf(stormConf.get("enable.auto.commit"));
        String keyDeserializer = String.valueOf(stormConf.get("key.deserializer"));
        String valueDeserializer = String.valueOf(stormConf.get("value.deserializer"));
        String sessionTimeout = String.valueOf(stormConf.get("session.timeout.ms"));
        Properties props = new Properties();
        //brokerServer(kafka)ip地址,不需要把所有集群中的地址都写上，可是一个或一部分
        props.put("bootstrap.servers", bootstrapServers);
        //设置consumer group name,必须设置
        props.put("group.id", consumerGroupId);
        //设置自动提交为false 采用手动提交
        props.put("enable.auto.commit", enableAutoCommit);
        //设置key以及value的解析（反序列）类
        props.put("key.deserializer", keyDeserializer);
        props.put("value.deserializer", valueDeserializer);
        //设置心跳时间
        props.put("session.timeout.ms", sessionTimeout);
        return props;
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
        for (ConsumerRecord<String, String> record : records) {
            this.handleRecord(record);
        }
    }

    private void handleRecord(ConsumerRecord<String, String> record) {
        log.info("--->start to handle record:{}", record);
        if (record == null || StringUtils.isEmpty(record.value())) {
            return;
        }
        String value = record.value();
        String[] logEvent = value.split(":");
        //格式不正确
        if (logEvent.length != 2) {
            return;
        }
        String streamId = LogEventUtils.getStreamId(logEvent[0]);
        if (StringUtils.isEmpty(streamId)) {
            return;
        }
        ILogEventConvert logeventConvert = LogEventUtils.getLogEventConvert(logEvent[0]);
        if (logeventConvert == null) {
            return;
        }
        BaseLogEvent baseLogEvent = logeventConvert.convert(value);
        log.info("--->convert baseLogEvent:{}", baseLogEvent);
        collector.emit(streamId, new Values(logEvent[0], baseLogEvent));
        log.info("--->emit event:{}", baseLogEvent);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream(CollectEvent.REGISTER.getStreamId(),
                new Fields(CollectEvent.REGISTER.name(), MallRegisterEvent.class.getSimpleName()));
    }

    @Override
    public void close() {
        closed.set(true);
        consumer.close();
    }

}
