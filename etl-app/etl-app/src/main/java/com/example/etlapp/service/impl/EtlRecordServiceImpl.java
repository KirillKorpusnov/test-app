package com.example.etlapp.service.impl;

import com.example.etlapp.client.LegacyAppClient;
import com.example.etlapp.dto.EtlRecordDto;
import com.example.etlapp.mapper.EtlRecordToDtoMapper;
import com.example.etlapp.model.EtlRecord;
import com.example.etlapp.repository.EtlRecordRepository;
import com.example.etlapp.service.EtlRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtlRecordServiceImpl implements EtlRecordService {

  private final EtlRecordToDtoMapper etlRecordToDtoMapper;
  private final LegacyAppClient legacyAppClient;
  private final EtlRecordRepository etlRecordRepository;

  @Override
  public void getLegacyRecord(Long id) {

    EtlRecordDto recordDto = legacyAppClient.findById(id);
    EtlRecord record = etlRecordToDtoMapper.legacyRecordDtoToRecord(recordDto);

     etlRecordRepository.save(record);
  }

}
