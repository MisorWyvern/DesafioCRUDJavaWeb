package crudjava.desafio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/atualizarAluno", method = RequestMethod.GET)
	public ModelAndView attAluno(ModelAndView model) {
		Aluno attAluno = new Aluno();
		model.addObject("aluno",attAluno);
		model.setViewName("atualizarAluno");
		return model;
	}
	
	@RequestMapping(value = "/salvarAluno", method = RequestMethod.POST)
	public ModelAndView salvarAluno(@ModelAttribute Aluno aluno) {
		if(aluno.getId_aluno() != null) {
			alunoDAO.save(aluno);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editarAlunoForm", method = RequestMethod.POST)
	public ModelAndView editarAluno(@ModelAttribute Aluno aluno) {
		if(aluno.getId_aluno() != null) {
			alunoDAO.update(aluno);
		}
		
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editarAluno", method = RequestMethod.GET)
	public ModelAndView editarAluno(HttpServletRequest request) {
		Integer id_aluno = Integer.parseInt(request.getParameter("id_aluno"));
		Aluno aluno = alunoDAO.get(id_aluno);
		
		ModelAndView model = new ModelAndView("atualizarAluno");
		
		model.addObject("aluno",aluno);
				
		return model;
	}
	
	@RequestMapping(value = "/removerAluno", method = RequestMethod.GET)
	public ModelAndView removerAluno(@RequestParam Integer id_aluno) {
		alunoDAO.delete(id_aluno);
		
		return new ModelAndView("redirect:/");
	}
}
