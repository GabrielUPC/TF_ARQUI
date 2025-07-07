package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Rol;
import pe.edu.upc.trabajoarquiweb.entities.Usuario;
import pe.edu.upc.trabajoarquiweb.repositories.IRolRepository;
import pe.edu.upc.trabajoarquiweb.repositories.IUsuarioRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
//wa
    @Autowired
    private IUsuarioRepository uR;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        // Codifica la contraseña ANTES de guardar
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
        uR.save(usuario);
    }

    @Override
    public Usuario searchId(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    public void update(Usuario usuario) {
        // Asegurarte de que cada Rol tenga asignado su Usuario
        if (usuario.getRoles() != null) {
            for (Rol rol : usuario.getRoles()) {
                rol.setUser(usuario); // ✅ Esto evita el error
            }
        }

        uR.save(usuario); // o .saveAndFlush(usuario)
    }
    @Autowired
    private IRolRepository rR;

    @Override
    public void delete(int id) {
        Optional<Usuario> opt = uR.findById(id);
        if (opt.isPresent()) {
            Usuario usuario = opt.get();

            // Elimina cada rol desde el repositorio
            for (Rol rol : usuario.getRoles()) {
                rR.delete(rol); // usa tu RolRepository aquí
            }

            // Ahora sí elimina el usuario
            uR.deleteById(id);
        }
    }



    @Override
    public List<String[]> cantidadVehiculosPorUsuario() {
        return uR.cantidadVehiculosPorUsuario();
    }


    public List<Usuario> filtrarUsuariosPorEdad(int min, int max) {
        return uR.filtrarPorEdad(min, max);
    }

    @Override
    public Usuario findByUsername(String username) {
        return uR.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
    @Override
    public void cambiarEstado(int id) {
        Optional<Usuario> optionalUsuario = uR.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setEnabled(!usuario.isEnabled()); // alternar estado
            uR.save(usuario);
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado");
        }
    }
}
