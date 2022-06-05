package com.guliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guliver.models.HotelModel;
import com.guliver.repositories.HotelRepository;

@Controller
@RequestMapping("/")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	@GetMapping("hello")
	public String hello(Model request) {
		request.addAttribute("nome", "PESSOAL..!");
		return "hello";
	}
	
	@GetMapping("/explore")
	public String explore(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("explore", lista);	
		return "guliver-master/explore";
	}

	@GetMapping("/admin")
	public String admin(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("admin", lista);	
		return "guliver-master/admin";
	}

	@GetMapping("/listaDados")
	public String listaDados(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("listaDados", lista);	
		return "listaDados";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@PostMapping("/formularioNovo")
	public String formularioNovo(HotelModel requisicao) {
		requisicao.setStatus("Pendente");
		hotelRepository.save(requisicao);
		return "redirect:/listaDados";
	}
	
	@GetMapping("/update/{id}/{status}")
	public String update(@PathVariable Long id, @PathVariable String status) {
		
		HotelModel pet = hotelRepository.getById(id);
		pet.setStatus(status);
		
		hotelRepository.save(pet);
		
		return "redirect:/index";
	}
	
	
	@GetMapping("/index")
	public String index(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("listaDados", lista);	
		return "guliver-master/index";
	}
	
	@GetMapping("/historico")
	public String historico() {
		return "guliver-master/historico";
	}
	
	@PostMapping("/denunciaNovo")
	public String denunciaNovo(HotelModel requisicao) {
		requisicao.setStatus("Pendente");
		hotelRepository.save(requisicao);
		return "redirect:/index";
	}

}
