package com.guiestephano.designpatterns.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.guiestephano.designpatterns.models.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
	@GetMapping("/{cep}/json")
	Endereco consutarCep(@PathVariable("cep")String cep);
}
