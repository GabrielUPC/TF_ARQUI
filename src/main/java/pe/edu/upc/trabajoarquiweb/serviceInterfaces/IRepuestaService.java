package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Respuesta;

import java.util.List;

public interface IRepuestaService {

    public List<Respuesta> list();
    public void insert(Respuesta r);
    public Respuesta searchId(int id);
    public void update(Respuesta r);
    public void delete(int id);
    Respuesta findByConsultaId(int consultaId);
}
