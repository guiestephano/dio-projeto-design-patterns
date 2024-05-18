package com.guiestephano.designpatterns.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiestephano.designpatterns.models.Cliente;
import com.guiestephano.designpatterns.repositories.ClienteRepository;
import com.guiestephano.designpatterns.services.strategies.ClienteServiceStrategy;

@Service
public class ClienteService implements ClienteServiceStrategy{
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
