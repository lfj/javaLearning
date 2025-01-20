package kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class KafkaConsumerAnalysis {

    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

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
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Arrays.asList(topic));

        consumer.subscribe(Pattern.compile("topic-.*"));

        List<TopicPartition> partitions = new ArrayList<>();
        List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);
        if (partitionInfos != null) {
            for (PartitionInfo partitionInfo: partitionInfos) {
                partitions.add(new TopicPartition(partitionInfo.topic(), partitionInfo.partition()));
            }
        }
        consumer.assign(partitions);

        Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
        consumer.subscribe(Arrays.asList(topic), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                consumer.commitSync(currentOffsets);
                currentOffsets.clear();
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {

            }
        });

        try {
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000).toMillis());
                for (ConsumerRecord<String, String> record: records) {
                    System.out.println("topic=" + record.topic() + ", partition=" + record.partition() + ",offset=" + record.offset());
                    System.out.println("key=" + record.key() + ",value=" + record.value());
                    //do something to process record
                    currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset() + 1));
                    consumer.commitSync(currentOffsets);
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
