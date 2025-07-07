package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Denuncia;

import java.util.List;

public interface IDenunciaService {
    public List<Denuncia> list();
    public void insert(Denuncia denuncia);
    public void update(Denuncia denuncia);
    public void delete(int id);
    public Denuncia searchId(int id);
    public List<Denuncia> buscarDenunciaPorId(int id);
    List<String[]> buscarPorEstado(String estado);

}
