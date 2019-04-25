package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.repositories.JobRepository;
import com.lmbarquillo.curriculer.services.JobService;

public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


}
