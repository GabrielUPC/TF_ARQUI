package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Comisaria;
import pe.edu.upc.trabajoarquiweb.repositories.IComisariaRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IComisariaService;

import java.util.List;
@Service
public class ComisariaServiceimplement implements IComisariaService {

    @Autowired
    private IComisariaRepository cR;

    @Override
    public List<Comisaria> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Comisaria comisaria) {
        cR.save(comisaria);
    }

    @Override
    public void update(Comisaria comisaria) {
        cR.save(comisaria);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<String[]> buscarComisariaPorDistrito(String distrito) {
        return cR.buscarComisariaPorDistrito(distrito);}
    @Override
    public List<String[]> cantidaddenunciasporcomisaria() {
        return cR.cantidaddenunciasporcomisaria();
    }

    @Override
    public Comisaria searchId(int id) {
        return cR.findById(id).orElse(new Comisaria());
    }


}
