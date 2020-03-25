package com.migrationbatch.demo;

import com.migrationbatch.demo.dao.ClientV2Repository;
import com.migrationbatch.demo.dao.ClientV3Repository;
import com.migrationbatch.demo.entities.ClientV2;
import com.migrationbatch.demo.entities.ClientV3;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static java.util.Collections.singletonMap;

@Configuration
@EnableBatchProcessing
@EnableJpaRepositories
public class JobBatchConfig {
    private static final int CHUNK = 100;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<ClientV2> v2ItemReader;
    @Autowired
    private ItemProcessor<ClientV2, ClientV3> v2ItemProcessor;
    @Autowired
    private ItemWriter<ClientV3> v3ItemWriter;

    public ExecutionContext context;
    @Bean
    @StepScope
    public ItemReader<ClientV2> v2ItemReader(ClientV2Repository v2Repo, @Value("#{jobParameters[siteName]}") String sitee) {
        RepositoryItemReader<ClientV2> reader = new RepositoryItemReader<>();
        String site = "test";
        //context.put("site_name",site);
        reader.setRepository(v2Repo);
        //reader.setMethodName("findAll");
        reader.setMethodName("findClients");
        reader.setMaxItemCount(200);
        //reader.setPageSize(CHUNK);
        reader.setSort(singletonMap("id", Sort.Direction.ASC));
        System.out.println(sitee);

        return reader;
    }

    @Bean
    public Job bankJob() {
        Step step1 = stepBuilderFactory
                .get("step-load-data")
                .<ClientV2, ClientV3>chunk(1)
                //.reader(v2ItemReader)
                .reader(v2ItemReader)
                .processor(v2ItemProcessor)
                .writer(v3ItemWriter)
                .build();

        return jobBuilderFactory.get("bank-data-loader-job")
                .start(step1)
                .build();
    }


}
