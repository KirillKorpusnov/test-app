package com.example.legacyapp.dto;

import com.example.legacyapp.model.TextEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegacyRecordDto {

    public Long id;

    public TextEnum type;

    public TextEnum businessValue;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;
}
