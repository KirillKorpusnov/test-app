package com.example.legacyapp.service.impl;

import com.example.legacyapp.dto.KafkaMessage;
import com.example.legacyapp.service.KafkaProducerService;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;


@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducerServiceImpl implements KafkaProducerService {
  final String testTopic = "test_topic";

  private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

  @Override
  public void sendMessage(KafkaMessage message) {
    CompletableFuture<SendResult<String, KafkaMessage>> future = kafkaTemplate.send(testTopic, message);
    future.whenComplete((result, ex) -> {
      if (ex == null) {
        log.info("Sent message=[" + message +
            "] with offset=[" + result.getRecordMetadata().offset() + "]");
      } else {
        log.info("Unable to send message=[" +
            message + "] due to : " + ex.getMessage());
      }
    });
  }


}
