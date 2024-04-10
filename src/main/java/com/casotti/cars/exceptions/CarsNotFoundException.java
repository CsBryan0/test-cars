package com.casotti.cars.exceptions;

public class CarsNotFoundException extends RuntimeException{
    public CarsNotFoundException(Integer id){
        super("Carro não encontado com o ID " + id);
    }
}
