package com.casotti.cars.exceptions;

public class BrandNotFoundException extends RuntimeException{
    public BrandNotFoundException(Integer id){
        super("Marca não encontrada com o ID " + id);
    }
}
