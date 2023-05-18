package com.example.etlapp.mapper;

import com.example.etlapp.dto.EtlRecordDto;
import com.example.etlapp.model.EtlRecord;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EtlRecordToDtoMapper {
  EtlRecordToDtoMapper INSTANCE = Mappers.getMapper(EtlRecordToDtoMapper.class);

  EtlRecord legacyRecordDtoToRecord(EtlRecordDto recordDto);

  @Mapping(target = "id", source = "dto.id")
  @Mapping(target = "type", source = "dto.type", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "businessValue", source = "dto.businessValue", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "createdAt", source = "dto.createdAt", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "updatedAt",
      expression = "java(getUpdateTime())")
  EtlRecord mergeWithDto(EtlRecordDto dto, EtlRecord record);

  default LocalDateTime getUpdateTime() {
    return LocalDateTime.now();
  }
}
