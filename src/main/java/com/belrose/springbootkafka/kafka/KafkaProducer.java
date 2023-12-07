package com.belrose.springbootkafka.kafka;

import com.belrose.springbootkafka.config.KafkaConfigTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
     private final KafkaTemplate<String,String> kafkaTemplate;
      private final KafkaConfigTopic kafkaConfigTopic;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaConfigTopic kafkaConfigTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigTopic = kafkaConfigTopic;
    }

    public void sendMessage(String message){
        log.info(String.format("KafkaProducer->sendMessage: Message sent %s",message));
        kafkaTemplate.send(kafkaConfigTopic.getTopicName(),message);
    }
}
