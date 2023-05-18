package com.example.legacyapp.repository;

import com.example.legacyapp.model.LegacyRecord;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface LegacyRecordRepository extends JpaRepository<LegacyRecord, Long> {

  @NonNull
  Optional<LegacyRecord> findById(@NonNull Long id);
}
