package com.guiestephano.designpatterns.services.strategies;

import com.guiestephano.designpatterns.models.Cliente;

public interface ClienteServiceStrategy {
	Iterable<Cliente> buscarTodos();
	Cliente buscarPorId(Long id);
	void inserir(Cliente cliente);
	void atualizar(Long id,Cliente cliente);
	void deletar(Long id);
}
