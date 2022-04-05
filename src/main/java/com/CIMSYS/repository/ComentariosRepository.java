package com.CIMSYS.repository;

import com.CIMSYS.entity.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends CrudRepository<Comentario,Long>{
    
}
