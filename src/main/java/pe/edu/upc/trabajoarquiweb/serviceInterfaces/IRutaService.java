package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.entities.Ruta;

import java.time.LocalDate;
import java.util.List;

public interface IRutaService {
    public List<Ruta> list();
    public void insert(Ruta r);
    public Ruta searchId(int id);
    public void update(Ruta r);
    public void delete(int id);
    public List<String[]> RutasenPeriodo( LocalDate fecha1,
                                         LocalDate fecha2,
                                          String placa);
}
