package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Respuesta;
import pe.edu.upc.trabajoarquiweb.repositories.IRespuestaRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRepuestaService;

import java.util.List;
@Service
public class RespuestaServiceImplement implements IRepuestaService {

    @Autowired
    private IRespuestaRepository rR;

    @Override
    public List<Respuesta> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Respuesta r) {
        rR.save(r);
    }

    @Override
    public Respuesta searchId(int id) {
        return rR.findById(id).orElse(new Respuesta());
    }

    @Override
    public void update(Respuesta r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }
    @Override
    public Respuesta findByConsultaId(int consultaId) {
        return rR.findByConsultaId(consultaId);
    }


}
