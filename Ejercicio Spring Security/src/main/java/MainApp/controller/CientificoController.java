package MainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MainApp.dto.Cientifico;
import MainApp.service.CientificoService;

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoService cientificoService;
	
	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos(){
		return cientificoService.listarCientificos();
	}
	
	@PostMapping("/cientificos")
	public Cientifico salvarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoService.guardarCientifico(cientifico);
	}
	
	@GetMapping("/cientificos/{id}")
	public Cientifico cientificoXID(@PathVariable(name="id") int id) {
		Cientifico cientifico_xid = new Cientifico();
		cientifico_xid = cientificoService.cientificoXID(id);
		return cientifico_xid;
	}
	
	@PutMapping("/cientificos/{id}")
	public Cientifico actualizarCientifico(@PathVariable(name="id") int id, @RequestBody Cientifico cientifico) {
		Cientifico cientifico_seleccionado = new Cientifico();
		Cientifico cientifico_actualizado = new Cientifico();
		
		cientifico_seleccionado = cientificoService.cientificoXID(id);
		
		cientifico_seleccionado.setNombre(cientifico.getNombre());
		
		cientifico_actualizado = cientificoService.actualizarCientifico(cientifico_seleccionado);
		
		return cientifico_actualizado;
	}
	
	@DeleteMapping("/cientificos/{id}")
	public void eliminarCientifico(@PathVariable(name="id") int id) {
		cientificoService.eliminarCientifico(id);
	}
}
