package com.example.etlapp.dto;

import com.example.etlapp.model.TextEnum;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtlRecordDto {

    public Long id;

    public TextEnum type;

    public TextEnum businessValue;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;
}
