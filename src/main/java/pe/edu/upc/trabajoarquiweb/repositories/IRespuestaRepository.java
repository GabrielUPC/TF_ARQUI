package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Respuesta;
@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta, Integer> {
    @Query("SELECT r FROM Respuesta r WHERE r.consulta.id = :consultaId")
    Respuesta findByConsultaId(@Param("consultaId") int consultaId);
}
