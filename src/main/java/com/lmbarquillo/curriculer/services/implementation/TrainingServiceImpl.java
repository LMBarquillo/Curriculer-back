package com.lmbarquillo.curriculer.services.implementation;

import com.lmbarquillo.curriculer.entities.Training;
import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.exceptions.generic.NotFoundException;
import com.lmbarquillo.curriculer.models.TrainingModel;
import com.lmbarquillo.curriculer.repositories.TrainingRepository;
import com.lmbarquillo.curriculer.services.TrainingService;
import com.lmbarquillo.curriculer.utilities.Values;
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

    @Override
    public TrainingModel insertTraining(User user, TrainingModel model) {
        Training training = new Training();
        training.setPromotion(model.getPromotion());
        training.setQualification(model.getQualification());
        training.setCenter(model.getCenter());
        training.setCity(model.getCity());
        training.setUser(user);

        return TrainingModel.from(trainingRepository.save(training));
    }

    @Override
    public TrainingModel updateTraining(User user, TrainingModel model) throws NotFoundException {
        Training training = trainingRepository.findByIdAndUser(model.getId(), user).orElseThrow(() -> new NotFoundException(Values.Errors.TRAINING_NOT_FOUND));
        training.setPromotion(model.getPromotion());
        training.setQualification(model.getQualification());
        training.setCenter(model.getCenter());
        training.setCity(model.getCity());

        return TrainingModel.from(trainingRepository.save(training));
    }

    @Override
    public void deleteTraining(User user, Long id) throws NotFoundException {
        Training training = trainingRepository.findByIdAndUser(id, user).orElseThrow(() -> new NotFoundException(Values.Errors.TRAINING_NOT_FOUND));
        trainingRepository.delete(training);
    }
}
