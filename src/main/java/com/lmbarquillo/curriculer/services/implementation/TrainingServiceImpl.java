package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.Training;
import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.TrainingModel;
import com.lmbarquillo.curriculer.repositories.TrainingRepository;
import com.lmbarquillo.curriculer.services.TrainingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    private TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<TrainingModel> getTrainings(User user) {
        List<Training> trainings = trainingRepository.getAllByUser(user).orElse(Collections.emptyList());
        return trainings.stream().map(TrainingModel::from).collect(Collectors.toList());
    }
}
