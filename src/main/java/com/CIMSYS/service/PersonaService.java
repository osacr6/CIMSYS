
package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import com.CIMSYS.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository IPersonaRepository;
    
    
    @Override
    public List<Persona> getAll(){
        return (List<Persona>)IPersonaRepository.findAll();
    }
    
    @Override
    public Persona getById(long id){
        return IPersonaRepository.findById(id).orElse(null);
    }
    
    @Override
    public Persona savePersona(Persona Persona){
        return IPersonaRepository.save(Persona);
    }
    
    @Override
    public Persona getPersona(long id){
        return IPersonaRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deletePersona (long id){
        IPersonaRepository.deleteById(id);
    }

    @Override
    public Persona login(Persona data) {
        Persona loggedUser= null;
        List<Persona> personas = (List<Persona>)IPersonaRepository.findAll();

        for(Persona usuario : personas){
            if( 
                usuario.getUserName()  != null &&
                usuario.getPassword()  != null &&
                usuario.getUserName().equals(data.getUserName()) &&
                usuario.getPassword().equals(data.getPassword()) 
            ) {
                loggedUser = usuario;
            }
        }
        
        if(loggedUser != null) {
            return loggedUser;
        }

        return null;
    }
    
    public Persona saveUsuario(Persona data){
        return IPersonaRepository.save(data);
    }
}
