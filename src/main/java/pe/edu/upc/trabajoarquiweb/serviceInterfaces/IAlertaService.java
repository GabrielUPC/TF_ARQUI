package pe.edu.upc.trabajoarquiweb.serviceInterfaces;

import pe.edu.upc.trabajoarquiweb.dtos.alerta.MisAlertasDTO;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;

import java.time.LocalDate;
import java.util.List;

public interface IAlertaService {
    public List<Alerta> list();
    public void insert(Alerta alerta);
    public void update(Alerta alerta);
    public void delete(int id);
    public List<String[]> usersMoreAlert();
    public List<String[]> fechaAlertmore(LocalDate fecha1,LocalDate fecha2);
    public List<String[]> placaAlert(String placa);
    List<MisAlertasDTO> listarAlertasPorUsername(String username);
    public Alerta searchId(int id);
}
