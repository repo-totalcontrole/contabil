package br.com.totalcontroleti.contabil.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SegurancaController {

	@RequestMapping(value = { "/", "/welcome**"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Total Controle TI - Contabil");
		model.addObject("message", "Sessão Autenticada");
		model.setViewName("/seguranca/dashboard"); // JSP
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Total Controle TI - Contabil");
		model.addObject("message", "Sessão do Administrador");
		model.setViewName("/seguranca/admin"); // JSP

		return model;

	}

}