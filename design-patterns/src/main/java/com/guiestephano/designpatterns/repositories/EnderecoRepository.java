package com.guiestephano.designpatterns.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiestephano.designpatterns.models.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
