package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.Activity;
import com.lmbarquillo.curriculer.entities.Job;
import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.JobModel;
import com.lmbarquillo.curriculer.repositories.ActivityRepository;
import com.lmbarquillo.curriculer.repositories.JobRepository;
import com.lmbarquillo.curriculer.repositories.SectorRepository;
import com.lmbarquillo.curriculer.services.JobService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;
    private SectorRepository sectorRepository;
    private ActivityRepository activityRepository;

    public JobServiceImpl(JobRepository jobRepository,
                          SectorRepository sectorRepository,
                          ActivityRepository activityRepository) {
        this.jobRepository = jobRepository;
        this.sectorRepository = sectorRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public List<JobModel> getJobs(User user) {
        return jobRepository.findAllByUser(user).orElse(Collections.emptyList()).stream().map(JobModel::from).collect(Collectors.toList());
    }

    @Override
    public JobModel insertJob(User user, JobModel model) throws NotFoundException {
        Job job = new Job();
        job.setStartDate(model.getFrom());
        job.setEndDate(model.getTo());
        job.setEmployer(model.getEmployer());
        job.setCity(model.getCity());
        job.setSector(sectorRepository.findById(model.getSector().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.SECTOR_NOT_FOUND)));
        job.setUser(user);
        jobRepository.save(job);

        model.getActivities().forEach(activityModel -> {
            Activity activity = new Activity();
            activity.setActivity(activityModel.getActivity());
            activity.setJob(job);
            activityRepository.save(activity);
        });

        return model;
    }


}
