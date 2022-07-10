package com.hfwas.produceer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class CustomProducerSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 0 配置
        Properties properties = new Properties();
        // 链接集群 bootstrap.servers
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        // 指定对应的key和value的序列化 key.serializer,  org.apache.kafka.common.serialization.StringSerializer
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 指定对应的value的序列化起 value.serializer
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        // 1. 创建kafka生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        // 2。 发送数据
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("slyun-test", "hello-sync" + i)).get();
        }

        // 3 关闭资源
        kafkaProducer.close();
    }
}
