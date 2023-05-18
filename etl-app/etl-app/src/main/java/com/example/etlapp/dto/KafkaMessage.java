package com.example.etlapp.dto;

import com.example.etlapp.model.ActionEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaMessage implements Serializable {

  Long id;
  ActionEnum action;
  Long unixTime;

  public KafkaMessage() {};

  @JsonCreator
  public KafkaMessage(@JsonProperty("id") Long id,
      @JsonProperty("action") ActionEnum action,
      @JsonProperty("unixTime") Long unixTime) {
    this.setId(id);
    this.setAction(action);
    this.setUnixTime(unixTime);
  };

  @Override
  public String toString() {
    return "{" +
        "\"id\":\"" + id + '\"' +
        ", \"action\":\"" + action + '\"' +
        ", \"unixTime\":\"" + unixTime + '\"' +
        "}";
  }
}
