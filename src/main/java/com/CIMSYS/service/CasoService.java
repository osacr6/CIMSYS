
package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import com.CIMSYS.repository.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CasoService implements ICasoService {
    @Autowired
    private CasosRepository ICasoRepository;
    @Autowired
    private PersonaRepository IPersonaRepository;
    @Autowired
    private ComentariosRepository IComentariosRepository;
    
    @Override
    public List<Caso> getAll(String userId) {
        List<Caso> casos = (List<Caso>)ICasoRepository.findAll();
        List<Caso> resultado = new ArrayList<Caso>();
        
         for(Caso caso : casos){
             if(
                caso.getAsignado() != null &&
                String.valueOf(caso.getAsignado().getId()).equals(userId)
            ) {
                resultado.add(caso);  
            }
         }
         
        if(userId != null)  {
            return resultado;
        } else {
            return casos;
        }
    }
    
    @Override
    public Caso getById(long id){
        return ICasoRepository.findById(id).orElse(null);
    }
    
    @Override
    public void saveCaso(Caso Caso){
        ICasoRepository.save(Caso);
    }
    
    @Override
    public Caso getCaso(long id){
        return ICasoRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteCaso (long id){
        ICasoRepository.deleteById(id);
    }
    
    @Override
    public List<Comentario> getComentarios(long casoId){
        List<Comentario> comentarios = (List<Comentario>)IComentariosRepository.findAll();
        List<Comentario> resultado = new ArrayList<Comentario>();
        
         for(Comentario comentario : comentarios){
             if(
                comentario.getCaso() != null &&
                comentario.getCaso().getId() == casoId
            ) {
                resultado.add(comentario);  
            }
         }
        
        return resultado;
    }
    
    @Override
    public void saveComentario(Comentario comentario){
        IComentariosRepository.save(comentario);
    }
    
    @Override
    public Comentario getComentario(long id){
        return IComentariosRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteComentario (Comentario comentario){
        IComentariosRepository.deleteById(comentario.getId());
    }
}
