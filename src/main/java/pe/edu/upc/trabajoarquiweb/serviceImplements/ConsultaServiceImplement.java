package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;
import pe.edu.upc.trabajoarquiweb.repositories.IConsultaRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IConsultaService;

import java.util.List;

@Service
public class ConsultaServiceImplement implements IConsultaService {

    @Autowired
    private IConsultaRepository cR;

    @Override
    public List<Consulta> list() {
        return cR.findAll();
    }

    @Override
    public Consulta insert(Consulta c) {
        return cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Consulta c) {
        cR.save(c);
    }

    @Override
    public List<String[]> cantidadConsultasPorUsuario() {
        return cR.cantidadConsultasPorUsuario();
    }

    @Override
    public List<Consulta> listarConsultasPorUsername(String username) {
        return cR.findByUsuarioUsername(username);
    }

    @Override
    public Consulta searchId(int id) {
        return cR.findById(id).orElse(new Consulta());
    }
}
