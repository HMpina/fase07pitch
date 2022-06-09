package com.guliver.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guliver.models.HotelModel;
import com.guliver.repositories.HotelRepository;

@Controller
@RequestMapping("/")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
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

	@GetMapping("/hotel")
	public String hoteis(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("hotel", lista);	
		return "guliver-master/hotel";
	}

	@GetMapping("/concessionarias")
	public String concessionarias(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("concessionarias", lista);	
		return "guliver-master/concessionarias";
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

	
	
//	@GetMapping("/update/{id}/{status}")
//	public String update(@PathVariable Long id, @PathVariable String status) {
		
//		HotelModel pet = hotelRepository.getById(id);
//		pet.setStatus(status);
//		
//		hotelRepository.save(pet);
//		
//		return "redirect:/index";
//	}
	
	@GetMapping("/atualizarNota/{id}")
	public String atualizarNota(@PathVariable Long id) {
		
		HotelModel existente = hotelRepository.getById(id);
		existente.setNota(7.7);
		
		hotelRepository.save(existente);
		
		return "guliver-master/historicoHotel";
	}
	
	@GetMapping("/index")
	public String index(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("listaDados", lista);	
		return "index";
	}
	
	@GetMapping("/historicoHotel")
	public String historicoHotel(Model request) {
		List<HotelModel> lista = hotelRepository.findAll();
		request.addAttribute("historicoHotel", lista);
		return "guliver-master/historicoHotel";
	}

	@PostMapping("/reservarHotel")
	public String reservarHotel(HotelModel requisicao) {
		hotelRepository.save(requisicao);
		return "guliver-master/historicoHotel";
	}


	
	
	
}
