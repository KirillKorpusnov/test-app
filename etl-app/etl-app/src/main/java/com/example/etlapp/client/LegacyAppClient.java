package com.example.etlapp.client;

import com.example.etlapp.dto.EtlRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LegacyAppClient {

  private final WebClient webClient;

  public EtlRecordDto findById(Long id) {
    return webClient.get()
        .uri("/legacy/{id}", "id")
        .retrieve()
        .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                    clientResponse -> Mono.empty())
        .bodyToMono(EtlRecordDto.class)
        .block();
  }
}
