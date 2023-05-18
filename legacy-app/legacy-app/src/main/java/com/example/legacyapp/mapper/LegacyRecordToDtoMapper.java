package com.example.legacyapp.mapper;

import com.example.legacyapp.dto.LegacyRecordDto;
import com.example.legacyapp.model.LegacyRecord;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LegacyRecordToDtoMapper {
  LegacyRecordToDtoMapper INSTANCE = Mappers.getMapper(LegacyRecordToDtoMapper.class);

  LegacyRecordDto legacyRecordToDto(LegacyRecord record);

  @Mapping(target = "id", source = "dto.id")
  @Mapping(target = "type", source = "dto.type", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "businessValue", source = "dto.businessValue", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "createdAt", source = "dto.createdAt", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "updatedAt",
      expression = "java(getUpdateTime())")
  LegacyRecord mergeWithDto(LegacyRecordDto dto, LegacyRecord record);

  default LocalDateTime getUpdateTime() {
    return LocalDateTime.now();
  }
}
