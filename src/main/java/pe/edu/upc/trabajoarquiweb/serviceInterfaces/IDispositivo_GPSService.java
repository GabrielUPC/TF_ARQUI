package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;

import java.util.List;

public interface IDispositivo_GPSService {
    public List<Dispositivo_GPS> list();
    public void insert(Dispositivo_GPS gps);
    public void update(Dispositivo_GPS gps);
    public void delete(int id);
    List<Dispositivo_GPS> listarGPSPorUsername(String username);
    public Dispositivo_GPS searchId(int id);

}
