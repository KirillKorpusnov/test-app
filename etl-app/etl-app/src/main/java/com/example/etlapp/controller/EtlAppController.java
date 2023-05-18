package com.example.etlapp.controller;

import com.example.etlapp.dto.EtlRecordDto;
import com.example.etlapp.service.EtlRecordService;
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
public class EtlAppController {

  private final EtlRecordService etlRecordService;

  @GetMapping(value = "/{id}")
  public void getLegacyRecord(@PathVariable("id") Long id) {
    etlRecordService.getLegacyRecord(id);
  }

}
