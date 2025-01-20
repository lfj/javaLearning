package kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

public class KafkaProducerAnalysis {

    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";

    public static Properties initConfig() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(CLIENT_ID_CONFIG, "producer.client.id.demo");
        props.put(RETRIES_CONFIG, 10); // 重试次数
        return props;
    }

    public static void main(String[] args) {
        Properties props = initConfig();
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello, Kafka1");
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            producer.send(record).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // 同步方式
        try {
            Future<RecordMetadata> future = producer.send(record);
            RecordMetadata metadata = future.get();
            System.out.println(metadata.topic() + "-" + metadata.partition() + ":" + metadata.offset());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // 异步方式
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
            } else {
                System.out.println(metadata.topic() + "-" + metadata.partition() + " : " + metadata.offset());
            }
        });

        int i = 0;
        while (i < 100) {
            ProducerRecord<String, String> record1 = new ProducerRecord<>(topic, "msg" + i++);
            try {
                producer.send(record1).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }
}
