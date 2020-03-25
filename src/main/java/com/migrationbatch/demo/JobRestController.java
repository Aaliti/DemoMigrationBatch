package com.migrationbatch.demo;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JobRestController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @GetMapping("/startjob/{site_name}")
   // @Scheduled(cron = "0 */1 * * * ?")
    public void perform(@PathVariable("site_name") String site_name) throws Exception {

        //ModelAndView modelAndView = new ModelAndView("index");
        Map<String, JobParameter> params= new HashMap<>();
        params.put("time", new JobParameter(System.currentTimeMillis()));
        //params.put("site_name","test");
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        //JobParameters jobParameters = new JobParameters(params);
        jobParametersBuilder.addString("siteName",site_name);

        JobParameters jobParameters =jobParametersBuilder.toJobParameters();
        JobExecution execution = jobLauncher.run(job, jobParameters);

        //JobExecution jobExecution  = jobLauncher.run(job,jobParameters);
            System.out.println(".............. "+execution.getStatus()+"\n");


    }

}