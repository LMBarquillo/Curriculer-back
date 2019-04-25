package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.JobModel;
import com.lmbarquillo.curriculer.services.JobService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

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
}
