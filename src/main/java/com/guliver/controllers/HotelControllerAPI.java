package com.guliver.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guliver.models.HotelModel;
import com.guliver.repositories.HotelRepository;

@RestController
@RequestMapping("/petcare")
public class HotelControllerAPI {

	@Autowired
	private HotelRepository petcareRepository;	

	@GetMapping("/health")
	public String health() {
		return "Application is ON";
	}
	
	@PostMapping
	public HotelModel adicionar(@RequestBody HotelModel petcare) {
		return petcareRepository.save(petcare);
	}
	
	@GetMapping
	public List<HotelModel> listar() {
		return petcareRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelModel> buscar(@PathVariable Long id) {
		
		HotelModel petcare = petcareRepository.getById(id);
		
		if (petcare == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(petcare);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HotelModel> atualizar(@PathVariable Long id, 
			@RequestBody HotelModel petcare) {
		HotelModel existente = petcareRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(petcare, existente, "id");
		
		existente = petcareRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		HotelModel petcare = petcareRepository.getById(id);
		
		if (petcare == null) {
			return ResponseEntity.notFound().build();
		}
		
		petcareRepository.delete(petcare);
		
		return ResponseEntity.noContent().build();
	}
}
