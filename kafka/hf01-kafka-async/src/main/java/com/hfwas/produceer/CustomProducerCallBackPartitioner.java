package com.hfwas.produceer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomProducerCallBackPartitioner {
    public static void main(String[] args) throws InterruptedException {
        // 0 配置
        Properties properties = new Properties();
        // 链接集群 bootstrap.servers
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        // 指定对应的key和value的序列化 key.serializer,  org.apache.kafka.common.serialization.StringSerializer
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 指定对应的value的序列化起 value.serializer
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        // 自定义分区器
        properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.hfwas.produceer.MyPartitioner");

        // 1. 创建kafka生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        // 2。 发送数据
        for (int i = 0; i < 10; i++) {
            kafkaProducer.send(new ProducerRecord<>("slyun-test", "hel" + i), new Callback() {
                // 发送消息的回调设置
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (null == e) {
                        System.out.println("发送成功， " + recordMetadata.topic() + " "  + recordMetadata.partition());
                    }
                }
            });
        }

        // 3 关闭资源
        kafkaProducer.close();
    }
}
