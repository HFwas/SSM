package com.hfwas.produceer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class CustomProducer {
    public static void main(String[] args) {
        // 0 配置
        Properties properties = new Properties();
        // 链接集群 bootstrap.servers
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        // 指定对应的key和value的序列化 key.serializer,  org.apache.kafka.common.serialization.StringSerializer
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        // 指定对应的value的序列化起 value.serializer
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        // 1. 创建kafka生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        // 2。 发送数据
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("slyun-test","hello" + i));
        }

        // 3 关闭资源
        kafkaProducer.close();
    }
}
