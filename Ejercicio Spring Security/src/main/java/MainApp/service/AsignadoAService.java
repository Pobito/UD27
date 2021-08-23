package MainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MainApp.dao.IAsignadoADAO;
import MainApp.dto.AsignadoA;

@Service
public class AsignadoAService implements IAsignadoAService {

	@Autowired
	IAsignadoADAO iAsignadoADAO;
	
	@Override
	public List<AsignadoA> listarAsignadoA() {
		
		return iAsignadoADAO.findAll();
	}

	@Override
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA) {
		
		return iAsignadoADAO.save(asignadoA);
	}

	@Override
	public AsignadoA asignadoAXID(int id) {
		
		return iAsignadoADAO.findById(id).get();
	}

	@Override
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA) {
		
		return iAsignadoADAO.save(asignadoA);
	}

	@Override
	public void eliminarAsignadoA(int id) {
		
		iAsignadoADAO.deleteById(id);
	}

}
