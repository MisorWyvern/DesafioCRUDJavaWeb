package crudjava.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import crudjava.desafio.dao.IAlunoDAO;
import crudjava.desafio.model.Aluno;

@Controller
public class MainController {
	
	@Autowired
	private IAlunoDAO alunoDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView listaDeAlunos(ModelAndView model) {
		List<Aluno> listaDeAlunos = alunoDAO.list();
		model.addObject("listaDeAlunos",listaDeAlunos);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/adicionarAluno", method = RequestMethod.GET)
	public ModelAndView novoAluno(ModelAndView model) {
		Aluno novoAluno = new Aluno();
		model.addObject("aluno",novoAluno);
		model.setViewName("adicionarAluno");
		return model;
	}
	
	@RequestMapping(value = "/salvarAluno", method = RequestMethod.POST)
	public ModelAndView salvarAluno(@ModelAttribute Aluno aluno) {
		alunoDAO.save(aluno);
		
		return new ModelAndView("redirect:/");
	}
}
