package br.com.totalcontroleti.contabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.totalcontroleti.contabil.model.Usuario;
import br.com.totalcontroleti.contabil.service.UsuarioService;

@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@Autowired(required=true)
	@Qualifier(value="usuarioService")
	public void setUsuarioService(UsuarioService ps){
		this.usuarioService = ps;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String listUsuarios(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listUsuarios", this.usuarioService.listUsuarios());
		return "/cadastros/usuario";
	}
	
	//For add and update Usuario both
	@RequestMapping(value= "/usuario/add", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") Usuario p){
		
		if(p.getId() == 0){
			//new Usuario, add it
			this.usuarioService.addUsuario(p);
		}else{
			//existing Usuario, call update
			this.usuarioService.updateUsuario(p);
		}
		
		return "redirect:/usuarios";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUsuario(@PathVariable("id") int id){
		
        this.usuarioService.removeUsuario(id);
        return "redirect:/usuarios";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUsuario(@PathVariable("id") int id, Model model){
        model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
        model.addAttribute("listUsuarios", this.usuarioService.listUsuarios());
        return "/cadastros/usuario";
    }
	
}
