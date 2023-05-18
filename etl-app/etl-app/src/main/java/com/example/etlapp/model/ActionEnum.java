package com.example.etlapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ActionEnum {
  @JsonProperty("CREATE")
  CREATE,
  @JsonProperty("UPDATE")
  UPDATE,
  @JsonProperty("DELETE")
  DELETE
}
