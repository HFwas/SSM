package com.hfwas.produceer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomProducerParameters {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        // 配置缓冲区大小
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
        // 配置批次大小
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
        // 配置压缩
        // compression.type：压缩，默认 none，可配置值 gzip、snappy、lz4 和 zstd
        properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG,"snappy");
        // linger.ns
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "1");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 3; i++) {
            kafkaProducer.send(new ProducerRecord<>("slyun-test","hhhh"+i));
        }

        kafkaProducer.close();
    }

}
