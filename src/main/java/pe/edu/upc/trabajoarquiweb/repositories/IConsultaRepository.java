package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;

import java.util.List;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query(value = " SELECT u.id AS id_usuario, u.nombres, u.apellidos, COUNT(c.id) AS cantidad_consultas\n" +
            " FROM usuario u\n" +
            " LEFT JOIN consulta c ON u.id = c.id_user\n" +
            " GROUP BY u.id, u.nombres, u.apellidos\n" +
            " ORDER BY cantidad_consultas DESC;",nativeQuery = true)
    public List<String[]> cantidadConsultasPorUsuario();

    List<Consulta> findByUsuarioUsername(String username);

}
