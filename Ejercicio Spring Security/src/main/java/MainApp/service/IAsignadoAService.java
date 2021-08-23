package MainApp.service;

import java.util.List;

import MainApp.dto.AsignadoA;

public interface IAsignadoAService {

	public List<AsignadoA> listarAsignadoA();
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA);
	public AsignadoA asignadoAXID(int id);
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA);
	public void eliminarAsignadoA(int id);
}
