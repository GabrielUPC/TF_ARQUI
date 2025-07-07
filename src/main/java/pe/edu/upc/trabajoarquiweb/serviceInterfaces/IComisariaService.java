package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Comisaria;

import java.util.List;

public interface IComisariaService {
    public List<Comisaria> list();
    public void insert(Comisaria comisaria);
    public void update(Comisaria comisaria);
    public void delete(int id);
    public List<String[]> buscarComisariaPorDistrito(String distrito);
    public List<String[]> cantidaddenunciasporcomisaria();
    public Comisaria searchId(int id);
}
