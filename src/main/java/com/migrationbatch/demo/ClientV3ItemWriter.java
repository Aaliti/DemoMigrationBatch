package com.migrationbatch.demo;

import com.migrationbatch.demo.dao.ClientV3Repository;
import com.migrationbatch.demo.entities.ClientV3;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientV3ItemWriter implements ItemWriter<ClientV3> {
    @Autowired
    ClientV3Repository v3Repo;

    @Override
    public void write(List<? extends ClientV3> list) throws Exception {
        v3Repo.saveAll(list);
    }
}
