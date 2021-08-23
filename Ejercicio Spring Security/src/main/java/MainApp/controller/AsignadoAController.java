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

import MainApp.dto.AsignadoA;
import MainApp.service.AsignadoAService;

@RestController
@RequestMapping("/api")
public class AsignadoAController {

	@Autowired
	AsignadoAService asignadoAService;
	
	@GetMapping("/asignadoA")
	public List<AsignadoA> listarAsignadoA(){
		return asignadoAService.listarAsignadoA();
	}
	
	@PostMapping("/asignadoA")
	public AsignadoA salvarAsignadoA(@RequestBody AsignadoA asignadoA) {
		return asignadoAService.guardarAsignadoA(asignadoA);
	}
	
	@GetMapping("/asignadoA/{id}")
	public AsignadoA asignadoAXID(@PathVariable(name="id") int id) {
		AsignadoA asignadoA_xid = new AsignadoA();
		asignadoA_xid = asignadoAService.asignadoAXID(id);
		return asignadoA_xid;
	}
	
	@PutMapping("/asignadoA/{id}")
	public AsignadoA actualizarAsignadoA(@PathVariable(name="id") int id, @RequestBody AsignadoA asignadoA) {
		AsignadoA asignadoA_seleccionado = new AsignadoA();
		AsignadoA asignadoA_actualizado = new AsignadoA();
		
		asignadoA_seleccionado = asignadoAService.asignadoAXID(id);
		
		asignadoA_seleccionado.setCientifico(asignadoA.getCientifico());
		asignadoA_seleccionado.setProyecto(asignadoA.getProyecto());
		
		asignadoA_actualizado = asignadoAService.actualizarAsignadoA(asignadoA_seleccionado);
		
		return asignadoA_actualizado;
	}
	
	@DeleteMapping("/asignadoA/{id}")
	public void eliminarAsignadoA(@PathVariable(name="id") int id) {
		asignadoAService.eliminarAsignadoA(id);
	}
}
