package pe.edu.upc.trabajoarquiweb.serviceImplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Rol;
import pe.edu.upc.trabajoarquiweb.repositories.IRolRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll() ;
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<Rol> listByUser(int userId) {
        return rR.findByUserId(userId);    }
    @Override
    @Transactional
    public void cambiarRol(Long id, String nuevoRol) {
        Optional<Rol> optionalRol = rR.findById(Math.toIntExact(id));
        if (optionalRol.isPresent()) {
            Rol rol = optionalRol.get();
            rol.setRol(nuevoRol);
            rR.save(rol);
        }
    }


}
