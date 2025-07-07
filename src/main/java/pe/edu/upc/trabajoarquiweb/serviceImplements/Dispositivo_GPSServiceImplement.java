package pe.edu.upc.trabajoarquiweb.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;
import pe.edu.upc.trabajoarquiweb.repositories.IDispositivo_GPSRepository;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDispositivo_GPSService;

import java.util.List;

@Service
public class Dispositivo_GPSServiceImplement implements IDispositivo_GPSService {
    @Autowired
    private IDispositivo_GPSRepository gR;//(metodo)

    @Override
    public List<Dispositivo_GPS> list() {
        return gR.findAll();
    }

    @Override
    public void insert(Dispositivo_GPS g) {
        gR.save(g);
    }

    @Override
    public void update(Dispositivo_GPS g) {
        gR.save(g);
    }

    @Override
    public void delete(int id) {
        gR.deleteById(id);
    }

    @Override
    public List<Dispositivo_GPS> listarGPSPorUsername(String username) {
        return gR.findByVehiculoUsuarioUsername(username);
    }

    @Override
    public Dispositivo_GPS searchId(int id) {
        return gR.findById(id).orElse(new Dispositivo_GPS());
    }

}
