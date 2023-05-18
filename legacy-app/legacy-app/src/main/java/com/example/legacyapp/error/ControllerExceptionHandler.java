package com.example.legacyapp.error;

import com.example.legacyapp.dto.ErrorDto;
import com.example.legacyapp.exception.RecordNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

  @ExceptionHandler(value = {RecordNotFoundException.class})
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorDto resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {

    return ErrorDto.builder()
        .description(Arrays.toString(ex.getStackTrace()))
        .message(ex.getMessage())
        .statusCode(404)
        .timestamp(LocalDate.now())
        .build();
  }
}
