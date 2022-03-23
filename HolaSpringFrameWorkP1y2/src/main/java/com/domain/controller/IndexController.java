package com.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	@RequestMapping("/home")
	public String goIndex() {
		return "Index";
	}

	@RequestMapping("/")
	public String getPresentacion() {
		return "Prersentacion";
	}

	@RequestMapping("/listado")
	public String goListado(Model model) {
		model.addAttribute("titulo", "Listado de alumnos");
		model.addAttribute("profesor", "Gabriel Casas");
		return "Listado";
	}
}
