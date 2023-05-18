package com.example.legacyapp.service.impl;

import com.example.legacyapp.dto.KafkaMessage;
import com.example.legacyapp.dto.LegacyRecordDto;
import com.example.legacyapp.exception.RecordNotFoundException;
import com.example.legacyapp.mapper.LegacyRecordToDtoMapper;
import com.example.legacyapp.model.ActionEnum;
import com.example.legacyapp.model.LegacyRecord;
import com.example.legacyapp.model.TextEnum;
import com.example.legacyapp.repository.LegacyRecordRepository;
import com.example.legacyapp.service.KafkaProducerService;
import com.example.legacyapp.service.LegacyRecordService;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LegacyRecordServiceImpl implements LegacyRecordService {

  private final LegacyRecordToDtoMapper legacyRecordToDtoMapper;
  private final LegacyRecordRepository legacyRecordRepository;
  private final KafkaProducerService kafkaProducerService;

  @Override
  public LegacyRecordDto getLegacyRecord(Long id) {

    LegacyRecord record = legacyRecordRepository.findById(id).orElseThrow(() ->
        new RecordNotFoundException("No records with provided id"));

    return legacyRecordToDtoMapper.legacyRecordToDto(record);
  }

  @Override
  public LegacyRecordDto updateLegacyRecord(Long id, LegacyRecordDto legacyRecordDto) {
    LegacyRecord oldRecord = legacyRecordRepository.findById(id).orElseThrow(() ->
        new RecordNotFoundException("No records with provided id"));
    LegacyRecord newRecord = legacyRecordToDtoMapper.mergeWithDto(legacyRecordDto, oldRecord);

    legacyRecordRepository.save(newRecord);

    if (newRecord.type.equals(TextEnum.TYPE5) || newRecord.type.equals(TextEnum.TYPE4)) {
      kafkaProducerService.sendMessage(new KafkaMessage(id, ActionEnum.UPDATE, Instant.now().getEpochSecond()));
    }

    return legacyRecordToDtoMapper.legacyRecordToDto(newRecord);
  }

}
