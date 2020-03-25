//
//package com.migrationbatch.demo;
//
//
//import com.migrationbatch.demo.dao.ClientV2Repository;
//import com.migrationbatch.demo.entities.ClientV2;
//import com.migrationbatch.demo.entities.ClientV3;
//import org.springframework.batch.item.*;
//import org.springframework.batch.item.data.RepositoryItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import static java.util.Collections.singletonMap;
//import org.springframework.data.domain.Sort;
//
////@Component
//public class ClientV2ItemReader implements ItemReader<ClientV2>, ItemStream {
//
//    ExecutionContext context;
//
//    @Autowired
//    ClientV2Repository v2Repo;
//    @Override
//    public ClientV2 read(@Value("#{jobParameters[site_name]}") String sitee) throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        RepositoryItemReader<ClientV2> reader = new RepositoryItemReader<>();
//        String site = "test";
//        context.put("site_name",sitee);
//        reader.setRepository(v2Repo);
//        //reader.setMethodName("findAll");
//        reader.setMethodName("findClients");
//        reader.setMaxItemCount(2);
//        //reader.setPageSize(CHUNK);
//        reader.setSort(singletonMap("id", Sort.Direction.ASC));
//
//        return reader.read();
//    }
//
//    @Override
//    public void close() throws ItemStreamException {
//        // TODO Auto-generated method stub
//    }
//
//    @Override
//    public void open(ExecutionContext arg0) throws ItemStreamException {
//        context = arg0;
//    }
//
//    @Override
//    public void update(ExecutionContext arg0) throws ItemStreamException {
//        // TODO Auto-generated method stub
//        context = arg0;
//    }
//}

