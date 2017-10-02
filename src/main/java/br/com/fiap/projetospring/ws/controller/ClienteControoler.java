package br.com.fiap.projetospring.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetospring.ws.model.Cliente;
import br.com.fiap.projetospring.ws.service.ClienteService;

@RestController
public class ClienteControoler {
	
	@Autowired
	ClienteService clienteService;
	
	
	//End points
	//cadastrar
	@RequestMapping(method=RequestMethod.POST, value="/clientes" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		System.out.println("Cliente "+cliente.getNome()+" cadastrada com sucesso!");
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
		
		
	}
	//buscar
	@RequestMapping(method=RequestMethod.GET, value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes(){
		
		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
		
	}
	//excluir
	@RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
		
		Cliente clienteEncontrado = clienteService.buscarPorId(id);
		
		if(clienteEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clienteEncontrado);
		System.out.println("Cliente "+clienteEncontrado.getNome()+" removida com sucesso!");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//alterar
	@RequestMapping(method=RequestMethod.PUT, value="/clientes" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteAlterado = clienteService.alterar(cliente);
		System.out.println("Cliente "+cliente.getNome()+" alterado com sucesso!");
		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
		
		
	}

}
