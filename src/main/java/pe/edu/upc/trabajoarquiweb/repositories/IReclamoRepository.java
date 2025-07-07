package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;

import java.util.List;

@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {
    @Query(value="SELECT \n" +
            "    r.fecha, \n" +
            "    r.id, \n" +
            "    r.id_user, \n" +
            "    r.resuelto, \n" +
            "    r.asunto, \n" +
            "    r.descripcion \n" +
            "FROM \n" +
            "    reclamo r \n" +
            "WHERE \n" +
            "    r.resuelto = false;" ,nativeQuery = true)
    public List<String[]> reclamosinresolver();

    List<Reclamo> findByUsuarioUsername(String username);
}
