
package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import com.CIMSYS.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService implements IPersonaService{
    private Persona logged = null;
    
    @Autowired
    private PersonaRepository IPersonaRepository;
    @Autowired
    private UsuariosRepository IUsuariosRepository;
    
    
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
    public Persona login(Usuario data) {
        Usuario loggedUser = null;
        Persona loggedPersona= null;
        List<Usuario> usuarios = (List<Usuario>)IUsuariosRepository.findAll();
        List<Persona> personas = (List<Persona>)IPersonaRepository.findAll();

        for(Usuario usuario : usuarios){
            if( usuario.getUserName().equals(data.getUserName()) && usuario.getPassword().equals(data.getPassword()) ) {
                loggedUser = usuario;
            }
        }
        
        if(loggedUser != null) {
            for(Persona persona : personas){
                if( persona.getUsuario().getId() == loggedUser.getId()) {
                    logged = persona;
                    loggedPersona = persona;
                }
            }
            return loggedPersona;
        }

        return null;
    }
    
    public Persona getLogged(){
        return logged;
    }
    
    public Usuario saveUsuario(Usuario data){
        return IUsuariosRepository.save(data);
    }
}
