package br.upf.patrimony.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.upf.patrimony.entities.Departament;
import br.upf.patrimony.services.DepartamentService;

@RestController
@RequestMapping("/departament")
public class DepartamentResource {

	@Autowired
	private DepartamentService service;
	
	@GetMapping("/all")
	public List<Departament> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/byid/{id}")
	public Departament getbyid(@PathVariable long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Departament newDepartament(@RequestBody Departament departament) {
		return service.newRegister(departament);
	}
}
