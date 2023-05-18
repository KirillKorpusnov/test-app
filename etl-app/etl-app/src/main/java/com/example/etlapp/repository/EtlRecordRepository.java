package com.example.etlapp.repository;

import com.example.etlapp.model.EtlRecord;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface EtlRecordRepository extends JpaRepository<EtlRecord, Long> {

  @NonNull
  Optional<EtlRecord> findById(@NonNull Long id);
}
