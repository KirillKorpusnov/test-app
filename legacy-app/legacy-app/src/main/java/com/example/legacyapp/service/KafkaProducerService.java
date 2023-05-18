package com.example.legacyapp.service;

import com.example.legacyapp.dto.KafkaMessage;

public interface KafkaProducerService {
  void sendMessage(KafkaMessage message);
}
