package MainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import MainApp.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, Integer> {

}
