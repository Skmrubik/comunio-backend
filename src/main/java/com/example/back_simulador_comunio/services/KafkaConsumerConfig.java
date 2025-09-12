package com.example.back_simulador_comunio.services;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.back_simulador_comunio.entities.MensajeJugadorDTO;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, MensajeJugadorDTO> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // Permite la deserialización de un tipo específico (en este caso, MensajeJugadorDTO)
        JsonDeserializer<MensajeJugadorDTO> jsonDeserializer = new JsonDeserializer<>(MensajeJugadorDTO.class, false);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(configProps, null, jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MensajeJugadorDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MensajeJugadorDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}