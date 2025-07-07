package pe.edu.upc.trabajoarquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String username);




    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = " insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


    @Query(value = "SELECT \n" +
            "  u.id, \n" +
            "  u.nombres, \n" +

            "  COUNT(v.placa) AS cantidad_vehiculos\n" +
            "FROM \n" +
            "  usuario u\n" +
            "LEFT JOIN \n" +
            "  vehiculo v ON u.id = v.id_user\n" +
            "GROUP BY \n" +
            "  u.id, u.nombres, u.apellidos;",nativeQuery = true)
    List<String[]> cantidadVehiculosPorUsuario();

        @Query("SELECT u FROM Usuario u WHERE u.edad BETWEEN :min AND :max")
    List<Usuario> filtrarPorEdad(@Param("min") int min, @Param("max") int max);

    Optional<Usuario> findByUsername(String username);


}
