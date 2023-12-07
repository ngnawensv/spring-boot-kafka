package com.belrose.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigTopic {

    @Bean
    public NewTopic springbootkafkaTopic(){
        return TopicBuilder.name("springbootkafka")
               // .partitions(10)
                .build();
    }
}
