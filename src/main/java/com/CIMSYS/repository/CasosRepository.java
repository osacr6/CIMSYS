package com.CIMSYS.repository;

import com.CIMSYS.entity.Caso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasosRepository extends CrudRepository<Caso,Long>{
    
}
