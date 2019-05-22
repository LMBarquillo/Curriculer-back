package com.lmbarquillo.curriculer.controllers;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.TrainingModel;
import com.lmbarquillo.curriculer.services.TrainingService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TrainingController {
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(Values.EndPoints.TRAININGS)
    public ResponseEntity<List<TrainingModel>> getTrainings(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user) {
        return ResponseEntity.ok(trainingService.getTrainings(user));
    }

    @PostMapping(Values.EndPoints.TRAININGS)
    public ResponseEntity<TrainingModel> insertTraining(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                        @RequestBody TrainingModel model) {
        return ResponseEntity.ok(trainingService.insertTraining(user, model));
    }

    @PutMapping(Values.EndPoints.TRAININGS)
    public ResponseEntity<TrainingModel> updateTraining(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user,
                                                        @RequestBody TrainingModel model) throws NotFoundException {
        return ResponseEntity.ok(trainingService.updateTraining(user, model));
    }

    @DeleteMapping(Values.EndPoints.TRAININGS + "/{id}")
    public ResponseEntity<Long> deleteTraining(@RequestAttribute(Values.Strings.ATTRIBUTE_USER) User user, @PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(trainingService.deleteTraining(user, id));
    }
}
