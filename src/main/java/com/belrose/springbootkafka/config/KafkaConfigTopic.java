package com.belrose.springbootkafka.config;

import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Data
public class KafkaConfigTopic {

    @Value("${spring.kafka.topic.name}")
    private String topicName;
    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
    @Bean
    public NewTopic springbootkafkaTopic(){
        return TopicBuilder.name(this.getTopicName())
               // .partitions(10)
                .build();
    }
    @Bean
    public NewTopic springbootkafkaJsonTopic(){
        return TopicBuilder.name(this.getTopicJsonName())
                // .partitions(10)
                .build();
    }
}
