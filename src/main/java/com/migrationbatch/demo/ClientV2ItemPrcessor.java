package com.migrationbatch.demo;

import com.migrationbatch.demo.entities.ClientV2;
import com.migrationbatch.demo.entities.ClientV3;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClientV2ItemPrcessor implements
        ItemProcessor<ClientV2, ClientV3> {
    @Override
    public ClientV3 process(ClientV2 clientV2) throws Exception {
        ClientV3 clientV3 = new ClientV3();
        clientV3.setIdV2(clientV2.getId());
        clientV3.setNom(clientV2.getNom());
        clientV3.setCreatedBy("import");
        clientV3.setDateCreation(new Date());
        return clientV3;
    }
}
