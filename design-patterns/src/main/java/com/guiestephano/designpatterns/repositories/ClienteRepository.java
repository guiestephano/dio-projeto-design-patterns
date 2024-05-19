package com.guiestephano.designpatterns.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiestephano.designpatterns.models.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
