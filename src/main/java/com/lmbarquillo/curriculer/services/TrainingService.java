package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.TrainingModel;

import java.util.List;

public interface TrainingService {
    List<TrainingModel> getTrainings(User user);
}
