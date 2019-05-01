package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.TrainingModel;

import java.util.List;

public interface TrainingService {
    List<TrainingModel> getTrainings(User user);

    TrainingModel insertTraining(User user, TrainingModel model);

    TrainingModel updateTraining(User user, TrainingModel model) throws NotFoundException;

    Long deleteTraining(User user, Long id) throws NotFoundException;
}
