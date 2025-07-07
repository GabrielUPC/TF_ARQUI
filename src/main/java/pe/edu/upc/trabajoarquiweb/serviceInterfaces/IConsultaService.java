package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Consulta;

import java.util.List;

public interface IConsultaService {
    public List<Consulta> list();
    public Consulta insert(Consulta c);
    public void delete(int id);
    public void update(Consulta c);
    public List<String[]> cantidadConsultasPorUsuario();
    List<Consulta> listarConsultasPorUsername(String username);
    public Consulta searchId(int id);

}
