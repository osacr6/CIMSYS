package com.CIMSYS.repository;

import com.CIMSYS.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario,Long>{
    
}
