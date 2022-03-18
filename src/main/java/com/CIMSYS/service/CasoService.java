
package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import com.CIMSYS.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CasoService implements ICasoService{
    @Autowired
    private CasosRepository ICasoRepository;
    @Autowired
    private UsuariosRepository IUsuariosRepository;
    
    @Override
    public List<Caso> getAll() {
        return (List<Caso>)ICasoRepository.findAll();
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
}
