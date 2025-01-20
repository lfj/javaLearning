/*
package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

*/
/**
 * 优点：每个线程可以按顺序消费各个分区中的消息
 * 缺点：每个消费线程都要维护一个独立的TCP连接，如果分区数和consumerThreadNum的值都很大，那么会造成不小的开销
 *//*

public class FirstMultiConsumerThreadDemo {

    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo";

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();
        int consumerThreadNum = 4;
        for (int i = 0;i<consumerThreadNum;i++) {
            new KafkaConsumerThread(properties, topic).start();
        }
    }

    public static class KafkaConsumerThread extends Thread {
        private KafkaConsumer<String, String> kafkaConsumer;
        public KafkaConsumerThread(Properties properties, String topic) {
            this.kafkaConsumer = new KafkaConsumer<>(properties);
            this.kafkaConsumer.subscribe(Arrays.asList(topic));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100).toMillis());
                    for (ConsumerRecord<String, String> record: records) {
                        // 处理消息模块
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                kafkaConsumer.close();
            }
        }
    }
}
*/
