package com.migrationbatch.demo.dao;

import com.migrationbatch.demo.entities.ClientV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientV2Repository extends JpaRepository<ClientV2, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM clientv2 WHERE id NOT IN(SELECT idv2 FROM clientv3)"
            , countQuery = "SELECT COUNT(*) FROM clientv2 WHERE id NOT IN(SELECT idv2 FROM clientv3)")
    public Page<ClientV2> findClients(Pageable pageable);
}
