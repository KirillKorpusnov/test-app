package com.example.etlapp.service.impl;

import com.example.etlapp.dto.KafkaMessage;
import com.example.etlapp.service.KafkaConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
  @Override
  @KafkaListener(topics = "test_topic", containerFactory = "kafkaListenerContainerFactory")
  public void listenMessage(KafkaMessage message) {
    log.info("Received message from test_topic: " + message);
  }
}
