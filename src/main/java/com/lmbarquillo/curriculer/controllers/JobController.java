package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.JobModel;
import com.lmbarquillo.curriculer.models.SectorModel;
import com.lmbarquillo.curriculer.services.JobService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(Values.EndPoints.JOBS)
    public ResponseEntity<List<JobModel>> getJobs(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(jobService.getJobs(user));
    }

    @GetMapping(Values.EndPoints.SECTORS)
    public ResponseEntity<List<SectorModel>> getSectors(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(jobService.getSectors());
    }

    @PostMapping(Values.EndPoints.JOBS)
    public ResponseEntity<JobModel> insertJob(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                              @RequestBody JobModel model) throws NotFoundException {
        return ResponseEntity.ok(jobService.insertJob(user, model));
    }

    @PutMapping(Values.EndPoints.JOBS)
    public ResponseEntity<JobModel> updateJob(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                              @RequestBody JobModel model) throws NotFoundException {
        return ResponseEntity.ok(jobService.updateJob(user, model));
    }

    @DeleteMapping(Values.EndPoints.JOBS + "/{id}")
    public ResponseEntity<Long> deleteJob(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                             @PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(jobService.deleteJob(user, id));
    }

}
