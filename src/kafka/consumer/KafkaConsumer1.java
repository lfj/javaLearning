package kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class KafkaConsumer1 {

    public static final String brokerList = "192.168.204.11:9092,192.168.204.12:9092,192.168.204.13:9092";
    public static final String topic = "lfj0217";
    public static final String groupId = "consumer.group.demo";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topic));
        try {
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record: records) {
                    System.out.println("topic=" + record.topic() + ", partition=" + record.partition() + ",offset=" + record.offset());
                    System.out.println("key=" + record.key() + ",value=" + record.value());
                    //do something to process record
                }

                for (TopicPartition tp: records.partitions()) {
                    for (ConsumerRecord<String, String> record: records.records(tp)) {
                        System.out.println(record.partition() + ":" + record.value());
                    }
                }
            }
            consumer.unsubscribe();
            consumer.subscribe(new ArrayList<>());
            consumer.assign(new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
