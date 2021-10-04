package net.codejava.exame.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.exame.Modelo.Exame;
import net.codejava.exame.Service.ExameService;

@Controller // Indicar que é um Controller para o Spring
public class ExameController {

	@Autowired //Permite que o Spring injete a dependência e instancie o objeto
	private ExameService service;
	
	@RequestMapping("/") // Mapeia a URL que irá chamar o metodo
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		List<Exame> listExames = service.listAll();
		mav.addObject("listExame", listExames);
		return mav;
	}
	
	@RequestMapping("/novo")
	public String novoExameForm(Map<String, Object> model) {
	    Exame exame = new Exame();
	    model.put("exame", exame);
	    return "novo_exame";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvarExame(@ModelAttribute("exame") Exame exame) {
		String status = service.save(exame);
		
		if (status.equals("1")) { // Salvou com sucesso
			return "redirect:/";
		}
		return "erro";
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarExameForm(@RequestParam long id) { // Pega o parametro do front editar?id=${exame.id}
	    ModelAndView mav = new ModelAndView("editar_exame");
	    Exame exame = service.get(id);
	    mav.addObject("exame", exame);
	    return mav;
	}
	
	@RequestMapping("/deletar")
	public String deletarExameForm(@RequestParam long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/procurar")
	public ModelAndView procurar(@RequestParam String keyword) {
	    List<Exame> resultado = service.search(keyword);
	    ModelAndView mav = new ModelAndView("resultado_procura");
	    mav.addObject("resultado", resultado);
	    return mav;
	}	
}
