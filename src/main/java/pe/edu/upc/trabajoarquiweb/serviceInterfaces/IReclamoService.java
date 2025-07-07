package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Reclamo;

import java.util.List;

public interface IReclamoService {
    public List<Reclamo> list();
    public void insert(Reclamo r);
    public void delete(int id);
    public void update(Reclamo r);
    public List<String[]> reclamosinresolver();
    List<Reclamo> listarReclamosPorUsername(String username);
    public Reclamo searchId(int id);
}
