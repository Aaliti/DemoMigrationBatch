package com.migrationbatch.demo;

import com.migrationbatch.demo.entities.ClientV2;
import com.migrationbatch.demo.entities.ClientV3;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClientV2ItemPrcessor implements
        ItemProcessor<ClientV2, ClientV3>, ItemStream {

    public ExecutionContext context;
    @Override
    public ClientV3 process(ClientV2 clientV2) throws Exception {
        ClientV3 clientV3 = new ClientV3();
        clientV3.setIdV2(clientV2.getId());
        clientV3.setNom(clientV2.getNom()/*+context.get("site_name")*/);
        //System.out.println(context.getString("site_name"));
        clientV3.setCreatedBy("import");
        clientV3.setDateCreation(new Date());
        return clientV3;
    }



    @Override
    public void close() throws ItemStreamException {

    }
    @Override
    public void open(ExecutionContext arg0) throws ItemStreamException {
        // TODO Auto-generated method stub

    }
    @Override
    public void update(ExecutionContext arg0) throws ItemStreamException {
       //context = arg0;

    }

}
