package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.JobModel;

import java.util.List;

public interface JobService {
    List<JobModel> getJobs(User user);

    JobModel insertJob(User user, JobModel model) throws NotFoundException;
}
