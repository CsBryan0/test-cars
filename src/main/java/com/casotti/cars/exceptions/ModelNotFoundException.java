package com.casotti.cars.exceptions;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(Integer id){
        super("Modelo não encontrado. ID: " + id);
    }
}
