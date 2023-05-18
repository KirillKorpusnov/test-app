package com.example.legacyapp.service;

import com.example.legacyapp.dto.LegacyRecordDto;

public interface LegacyRecordService {

    LegacyRecordDto getLegacyRecord(Long id);

    LegacyRecordDto updateLegacyRecord(Long id, LegacyRecordDto legacyRecordDto);
}
