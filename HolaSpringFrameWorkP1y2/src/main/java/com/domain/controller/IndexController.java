package com.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.inetum.curso0.module.PiedraPapelTijeraFactory;


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

	@RequestMapping("/resolverJuego")
	public String goResolverJuego(@RequestParam(required = false) Integer selOpcion, Model model) {
		
		System.out.println("******************** paso por /resolverJuego ********************:" + selOpcion );
		//seleccion de la computadora
		PiedraPapelTijeraFactory computadora = PiedraPapelTijeraFactory.getInstance((int)(Math.random()*100%5+1));
		//este es el parametro que viene desde el JSP
		PiedraPapelTijeraFactory jugador = PiedraPapelTijeraFactory.getInstance(selOpcion.intValue());
		
		jugador.comparar(computadora);
		
		model.addAttribute("jugador", jugador);
		model.addAttribute("computadora", computadora);
		
		return "MostrarResultado";
	}
}
