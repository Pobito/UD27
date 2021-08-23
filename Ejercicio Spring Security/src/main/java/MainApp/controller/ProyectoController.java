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

import MainApp.dto.Proyecto;
import MainApp.service.ProyectoService;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos(){
		return proyectoService.listarProyectos();
	}
	
	@PostMapping("/proyectos")
	public Proyecto salvarProyectos(@RequestBody Proyecto proyecto) {
		return proyectoService.guardarProyecto(proyecto);
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoXID(@PathVariable(name="id") int id) {
		Proyecto proyecto_xid = new Proyecto();
		
		proyecto_xid = proyectoService.proyectoXID(id);
		return proyecto_xid;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")int id, @RequestBody Proyecto proyecto) {
		Proyecto proyecto_seleccionado = new Proyecto();
		Proyecto proyecto_actualizado = new Proyecto();
		
		proyecto_seleccionado = proyectoService.proyectoXID(id);
		
		proyecto_seleccionado.setHoras(proyecto.getHoras());
		proyecto_seleccionado.setNombre(proyecto.getNombre());
		
		proyecto_actualizado = proyectoService.actualizarProyecto(proyecto_seleccionado);
		
		return proyecto_actualizado;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name="id") int id) {
		proyectoService.eliminarProyecto(id);
	}
}
