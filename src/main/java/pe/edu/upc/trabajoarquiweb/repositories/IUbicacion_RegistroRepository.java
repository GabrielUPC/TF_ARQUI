package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;

import java.util.List;

@Repository
public interface IUbicacion_RegistroRepository extends JpaRepository<Ubicacion_Registro, Integer> {
    List<Ubicacion_Registro> findByDisGPSVehiculoUsuarioUsername(String username);

}
