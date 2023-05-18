package com.example.legacyapp.controller;

import com.example.legacyapp.dto.LegacyRecordDto;
import com.example.legacyapp.service.LegacyRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legacy")
@RequiredArgsConstructor
public class LegacySystemController {

  private final LegacyRecordService legacyRecordService;

  @GetMapping(value = "/{id}")
  public LegacyRecordDto getLegacyRecord(@PathVariable("id") Long id) {
    return legacyRecordService.getLegacyRecord(id);
  }

  @PatchMapping(value = "/{id}")
  public LegacyRecordDto updateLegacyRecord(@PathVariable("id") Long id, @RequestBody LegacyRecordDto legacyRecordDto) {
    return legacyRecordService.updateLegacyRecord(id, legacyRecordDto);
  }

}
