package com.sistematizacao.entregadores.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistematizacao.entregadores.dtos.EntregadoresDto;
import com.sistematizacao.entregadores.models.EntregadoresModel;
import com.sistematizacao.entregadores.repositories.EntregadorRepository;

import jakarta.validation.Valid;

@RestController
public class EntregadoresController {

	@Autowired
	EntregadorRepository entregadorRepository;

	@GetMapping("/entregadores")
	public ResponseEntity<List<EntregadoresModel>> listar() {
		List<EntregadoresModel> entregadorList = entregadorRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(entregadorList);
	}

	@PostMapping("/entregadores")
	public ResponseEntity<EntregadoresModel> salvar(@RequestBody @Valid EntregadoresDto entregadoresDto) {
		var entregadoresModel = new EntregadoresModel();
		BeanUtils.copyProperties(entregadoresDto, entregadoresModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(entregadorRepository.save(entregadoresModel));
	}

	@GetMapping("/entregadores/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value = "id") Long id) {
		Optional<EntregadoresModel> entregador = entregadorRepository.findById(id);
		if (entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado exibição.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(entregador.get());
	}

	@PutMapping("/entregadores/{id}")
	public ResponseEntity<Object> atualizarEntregador(@PathVariable(value = "id") Long id,
			@RequestBody @Valid EntregadoresDto entregadoresDto) {
		Optional<EntregadoresModel> entregador = entregadorRepository.findById(id);
		if (entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para edição.");
		}
		var entregadoresModel = entregador.get();
		BeanUtils.copyProperties(entregadoresDto, entregadoresModel);
		return ResponseEntity.status(HttpStatus.OK).body(entregadorRepository.save(entregadoresModel));
	}

	@DeleteMapping("/entregadores/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id) {
		Optional<EntregadoresModel> entregador = entregadorRepository.findById(id);
		if (entregador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado.");
		}
		entregadorRepository.delete(entregador.get());
		return ResponseEntity.status(HttpStatus.OK).body("O Entregador foi excluído.");
	}
}
