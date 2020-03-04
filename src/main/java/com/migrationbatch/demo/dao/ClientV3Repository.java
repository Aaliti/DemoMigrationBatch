package com.migrationbatch.demo.dao;

import com.migrationbatch.demo.entities.ClientV3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientV3Repository extends JpaRepository<ClientV3, Long> {
}
