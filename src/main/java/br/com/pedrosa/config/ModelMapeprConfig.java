package br.com.pedrosa.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ModelMapeprConfig {
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
