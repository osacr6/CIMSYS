
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
    @Autowired
    private UsuariosRepository IUsuariosRepository;
    
    @Override
    public void savePersona(Persona Persona){
        IPersonaRepository.save(Persona);
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
    public Persona login(Usuario data) {
        Usuario loggedUser = null;
        List<Usuario> Usuarios = (List<Usuario>)IUsuariosRepository.findAll();
        for(Usuario u : Usuarios){
            if( u.getUserName() == data.getUserName() && u.getPassword()== data.getPassword() ) {
                loggedUser = u;
            }
        }
        
        if(loggedUser != null) {
            return IPersonaRepository.findById(loggedUser.getPersona().getId()).orElse(null);
        }
        
        return null;
    }
}
