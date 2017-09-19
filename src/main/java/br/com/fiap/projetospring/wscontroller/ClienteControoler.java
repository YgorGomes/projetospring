package br.com.fiap.projetospring.wscontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetospring.wsmodel.Cliente;

@RestController
public class ClienteControoler {
	
	
	Map<Integer, Cliente> clientes;
	Integer proximoId = 0;
	
	//Negocios
	private Cliente cadastrar(Cliente cliente){
		
		if(clientes==null){
			clientes = new HashMap<>();
		}
		cliente.setId(proximoId);
		//criar id
		proximoId++;
		clientes.put(cliente.getId(), cliente);
		
		return cliente;
	}
	
	
	//End points
	@RequestMapping(method=RequestMethod.POST, value="/clientes" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteCadastrado = cadastrar(cliente);
		
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
		
	}

}
