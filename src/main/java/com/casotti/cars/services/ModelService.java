package com.casotti.cars.services;

import com.casotti.cars.domain.model.Model;
import com.casotti.cars.exceptions.ModelNotFoundException;
import com.casotti.cars.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public Model addModel (Model model){
        return modelRepository.save(model);
    }

    public List<Model> getAllModels(){
        return modelRepository.findAll();
    }

    public Optional<Model> listModelsById(Integer id){
        return modelRepository.findById(id);
    }

    public Model udpateModel(Model model){
        Optional<Model> modelToUpdate = modelRepository.findById(model.getId());

        if(modelToUpdate.isPresent()){
            Model updatedModel = modelToUpdate.get();

            updatedModel.setName(model.getName());
            updatedModel.setFipeValue(model.getFipeValue());

            return modelRepository.save(updatedModel);
        } else {
            throw new ModelNotFoundException(model.getId());
        }
    }

    public Model deleteModel(Integer id){
        Optional<Model> modelToDelete = modelRepository.findById(id);

        if(modelToDelete.isPresent()){
            Model deleteModel = modelToDelete.get();

            modelRepository.deleteById(deleteModel.getId());
            return deleteModel;
        } else {
            throw new ModelNotFoundException(id);
        }
    }


}
