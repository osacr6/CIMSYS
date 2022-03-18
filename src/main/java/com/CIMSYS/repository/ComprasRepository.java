package com.CIMSYS.repository;

import com.CIMSYS.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends CrudRepository<Compra,Long>{
    
}
