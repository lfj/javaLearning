package kafka.producer;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class ProducerInterceptorPrefix implements ProducerInterceptor<String, String> {

    private volatile long sendSucess = 0;
    private volatile long sendFailure = 0;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        String modifiedValue = "prefix1-" + producerRecord.value();
        return new ProducerRecord<>(producerRecord.topic(),
                producerRecord.partition(),
                producerRecord.timestamp(),
                producerRecord.key(),
                modifiedValue,
                producerRecord.headers()
        );
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (e == null) {
            sendSucess ++;
        } else {
            sendFailure ++;
        }
    }

    @Override
    public void close() {
        double successRatio = (double) sendSucess / (sendFailure + sendSucess);
        System.out.println("[INFO] 发送成功率=" + String.format("%f", successRatio * 100 + "%"));
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
