/*
package kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.ConfigResource;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaAdminClient1 {

    public static void main(String[] args) {
        String brokerList = "192.168.204.11:9092";
        String topic = "crt0218";
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
        AdminClient client = AdminClient.create(props);
        NewTopic newTopic = new NewTopic(topic, 4, (short) 1);
        CreateTopicsResult result = client.createTopics(Collections.singleton(newTopic));
        try {
            Void unused = result.all().get();

            ConfigResource resource = new ConfigResource(ConfigResource.Type.TOPIC, topic);
            DescribeConfigsResult describeConfigsResult = client.describeConfigs(Collections.singleton(resource));
            Config config = describeConfigsResult.all().get().get(resource);
            System.out.println(config);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        client.close();
    }
}
*/
