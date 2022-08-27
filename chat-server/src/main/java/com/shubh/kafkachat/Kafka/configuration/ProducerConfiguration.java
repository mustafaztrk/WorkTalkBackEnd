package com.shubh.kafkachat.Kafka.configuration;

import com.shubh.kafkachat.Kafka.constants.KafkaConstants;
import com.shubh.kafkachat.Entities.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ProducerConfiguration {
    //Mesajları kafka topic'ine göndermek için kullandıgım Producer
    @Bean
    public ProducerFactory<String, Message> producerFactory() {//üreticilerin nasıl oluşturulacağının ayarlandıgı kısım
        return new DefaultKafkaProducerFactory<>(producerConfigurations());
    }

    @Bean
    public Map<String, Object> producerConfigurations() {//Kafka'nın çalıştığı sunucu adresini ayarlamak için
        Map<String, Object> configurations = new HashMap<>();
        configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER);
        configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//Kuyruğundan anahtarı ve değeri seri durumdan çıkarmak için.
        configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);//Kuyruğundan anahtarı ve değeri seri durumdan çıkarmak için.
        return configurations;
    }

    @Bean
    public KafkaTemplate<String, Message> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}