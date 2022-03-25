package com.grabrielCode.controller	;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grabrielCode.model.Persona;
import com.grabrielCode.repo.IPersonaRepo;

@Controller
public class GreetingController {

	@Autowired
	private IPersonaRepo repo;
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		Persona persona = new Persona(1, "Gabriel Casas");
		repo.save(persona);
		model.addAttribute("name", name);
		return "greeting";
	}

}