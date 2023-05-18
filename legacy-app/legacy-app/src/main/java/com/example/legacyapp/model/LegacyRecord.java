package com.example.legacyapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "legacy_app_table", schema = "legacy_app")
public class LegacyRecord {

  @Id
  public Long id;

  @Enumerated(EnumType.STRING)
  public TextEnum type;

  @Column(name = "business_value")
  @Enumerated(EnumType.STRING)
  public TextEnum businessValue;

  @Column(name = "created_at")
  public LocalDateTime createdAt;

  @Column(name = "updated_at")
  public LocalDateTime updatedAt;

}
