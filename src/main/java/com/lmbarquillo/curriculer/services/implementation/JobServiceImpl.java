package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.Activity;
import com.lmbarquillo.curriculer.entities.Job;
import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.JobModel;
import com.lmbarquillo.curriculer.models.SectorModel;
import com.lmbarquillo.curriculer.repositories.ActivityRepository;
import com.lmbarquillo.curriculer.repositories.JobRepository;
import com.lmbarquillo.curriculer.repositories.SectorRepository;
import com.lmbarquillo.curriculer.services.JobService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<SectorModel> getSectors() {
        return sectorRepository.findAll().stream().map(SectorModel::from).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public JobModel insertJob(User user, JobModel model) throws NotFoundException {
        Job job = new Job();
        job.setStartDate(model.getFrom());
        job.setEndDate(model.getTo());
        job.setEmployer(model.getEmployer());
        job.setCity(model.getCity());
        job.setSector(sectorRepository.findById(model.getSector().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.SECTOR_NOT_FOUND)));
        job.setUser(user);
        model.getActivities().forEach(activityModel -> job.getActivities().add(new Activity(activityModel.getActivity(), job)));

        return JobModel.from(jobRepository.save(job));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public JobModel updateJob(User user, JobModel model) throws NotFoundException {
        Job job = jobRepository.findByUserAndId(user, model.getId()).orElseThrow(() -> new NotFoundException((Values.Errors.JOB_NOT_FOUND)));
        activityRepository.deleteAllByJob(job);
        job.setStartDate(model.getFrom());
        job.setEndDate(model.getTo());
        job.setEmployer(model.getEmployer());
        job.setCity(model.getCity());
        job.setSector(sectorRepository.findById(model.getSector().getId()).orElseThrow(() -> new NotFoundException(Values.Errors.SECTOR_NOT_FOUND)));
        job.getActivities().clear();
        model.getActivities().forEach(activityModel -> job.getActivities().add(new Activity(activityModel.getActivity(), job)));


        return JobModel.from(jobRepository.save(job));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Long deleteJob(User user, Long id) throws NotFoundException {
        Job job = jobRepository.findByUserAndId(user, id).orElseThrow(() -> new NotFoundException((Values.Errors.JOB_NOT_FOUND)));
        activityRepository.deleteAllByJob(job);
        jobRepository.delete(job);
        return id;
    }
}
