package com.guiestephano.designpatterns.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guiestephano.designpatterns.models.Endereco;
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{

}
