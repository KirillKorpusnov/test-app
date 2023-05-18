package com.example.legacyapp.exception;

public class RecordNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1234567L;

  public RecordNotFoundException(String message){
    super(message);
  }

}
