package com.example.etlapp.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

  private int statusCode;

  private LocalDate timestamp;

  private String message;

  private String description;
}
