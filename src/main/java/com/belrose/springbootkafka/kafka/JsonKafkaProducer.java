package com.belrose.springbootkafka.kafka;

import com.belrose.springbootkafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
        log.info(String.format("JsonKafkaProducer->sendMessage: user =>%s",data));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"springbootkafka_json")
                .build();
        log.info(String.format("JsonKafkaProducer->sendMessage: Message sent =>%s",message));
        kafkaTemplate.send(message);
    }
}
