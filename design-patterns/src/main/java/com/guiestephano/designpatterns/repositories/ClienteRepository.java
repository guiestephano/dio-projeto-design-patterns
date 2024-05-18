package com.guiestephano.designpatterns.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guiestephano.designpatterns.models.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
