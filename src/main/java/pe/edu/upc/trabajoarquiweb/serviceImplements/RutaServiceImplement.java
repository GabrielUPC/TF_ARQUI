package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Ruta;
import pe.edu.upc.trabajoarquiweb.repositories.IRutaRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRutaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RutaServiceImplement implements IRutaService {
    @Autowired
    private IRutaRepository rR;

    @Override
    public List<Ruta> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Ruta r) {
        rR.save(r);
    }

    @Override
    public Ruta searchId(int id) {
        return rR.findById(id).orElse(new Ruta());
    }

    @Override
    public void update(Ruta r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<String[]> RutasenPeriodo(LocalDate fecha1, LocalDate fecha2, String placa) {
        return rR.RutasenPeriodo(fecha1, fecha2, placa);
    }
}
