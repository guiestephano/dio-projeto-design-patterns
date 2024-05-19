package com.guiestephano.designpatterns.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiestephano.designpatterns.models.Cliente;
import com.guiestephano.designpatterns.models.Endereco;
import com.guiestephano.designpatterns.repositories.ClienteRepository;
import com.guiestephano.designpatterns.repositories.EnderecoRepository;
import com.guiestephano.designpatterns.services.strategies.ClienteServiceStrategy;

@Service
public class ClienteService implements ClienteServiceStrategy{
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ViaCepService viaCepService;
	
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
		salvaClienteComCep(cliente);
	}

	private void salvaClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consutarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		
		if(clienteBd.isPresent()) {
			salvaClienteComCep(cliente);
		}
		
		
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
	

}
