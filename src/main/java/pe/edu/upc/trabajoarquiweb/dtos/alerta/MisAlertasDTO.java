package pe.edu.upc.trabajoarquiweb.dtos.alerta;

import java.time.LocalDate;

public class MisAlertasDTO {
    private String asunto;
    private LocalDate fecha;
    private String descripcion;

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
