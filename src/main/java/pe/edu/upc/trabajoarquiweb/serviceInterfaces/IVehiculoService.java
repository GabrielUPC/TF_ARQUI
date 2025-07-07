package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    public List<Vehiculo> list();
    public void insert(Vehiculo vehiculo);
    public void update(Vehiculo vehiculo);
    public void delete(String placa);
    public Vehiculo buscarPorPlaca(String placa);
    List<Vehiculo> listarVehiculosPorUsername(String username);
}
