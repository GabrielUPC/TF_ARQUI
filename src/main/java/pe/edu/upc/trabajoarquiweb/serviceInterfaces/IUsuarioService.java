package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> list();
    public void insert(Usuario usuario);
    public Usuario searchId(int id);
    public void update(Usuario usuario);
    public void delete(int id);
    public List<String[]> cantidadVehiculosPorUsuario();

    List<Usuario> filtrarUsuariosPorEdad(int min, int max);

    Usuario findByUsername(String username);
    public void cambiarEstado(int id);

}
