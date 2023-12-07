package com.belrose.springbootkafka.kafka;

import com.belrose.springbootkafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(User user){
        log.info(String.format("JsonKafkaConsumer->consumer: Message received =>%s",user.toString()));
    }
}
