package MainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import MainApp.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, Integer>{

}
