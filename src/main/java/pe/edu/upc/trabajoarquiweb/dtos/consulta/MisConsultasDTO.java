package pe.edu.upc.trabajoarquiweb.dtos.consulta;

import java.sql.Time;
import java.time.LocalDate;

public class MisConsultasDTO {
    private String consulta;
    private LocalDate fecha;
    private Time hora;

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
