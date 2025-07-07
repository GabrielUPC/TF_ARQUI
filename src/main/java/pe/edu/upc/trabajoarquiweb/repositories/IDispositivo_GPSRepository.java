package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;

import java.util.List;

@Repository
public interface IDispositivo_GPSRepository extends JpaRepository<Dispositivo_GPS, Integer> {

    List<Dispositivo_GPS> findByVehiculoUsuarioUsername(String username);
}
