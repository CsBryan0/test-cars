package com.casotti.cars.controllers;

import com.casotti.cars.domain.model.Model;
import com.casotti.cars.exceptions.ModelNotFoundException;
import com.casotti.cars.services.ModelService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping
    public ResponseEntity<Model> postModel(@RequestBody Model model){
        Model createModel = modelService.addModel(model);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createModel);
    }

    @GetMapping
    public ResponseEntity<List<Model>> getAllModels(){
        List<Model> models = modelService.getAllModels();
        return ResponseEntity.ok(models);
    }

    @PostMapping("/{modelId}")
    public ResponseEntity<Model> updateModels(@PathVariable Integer modelId, @RequestBody Model model){
        try{
            Model updated = modelService.udpateModel(model);
            return ResponseEntity.ok(updated);
        } catch (ModelNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModels(@PathVariable Integer id){
        try{
            modelService.deleteModel(id);
            return ResponseEntity.ok().build();
        } catch (ModelNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
