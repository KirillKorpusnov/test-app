package com.example.etlapp.service;

import com.example.etlapp.dto.KafkaMessage;

public interface KafkaConsumerService {
  void listenMessage(KafkaMessage message);
}
