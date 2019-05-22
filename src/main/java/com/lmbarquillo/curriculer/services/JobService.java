package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.JobModel;
import com.lmbarquillo.curriculer.models.SectorModel;

import javax.transaction.Transactional;
import java.util.List;

public interface JobService {
    List<JobModel> getJobs(User user);

    List<SectorModel> getSectors();

    JobModel insertJob(User user, JobModel model) throws NotFoundException;

    @Transactional(rollbackOn = Exception.class)
    JobModel updateJob(User user, JobModel model) throws NotFoundException;

    Long deleteJob(User user, Long id) throws NotFoundException;
}
