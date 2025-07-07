package pe.edu.upc.trabajoarquiweb.dtos.alerta;

import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.VehiculoDTO;

import java.time.LocalDate;

public class AlertaDTO {
    private int id;
    private String asunto;
    private LocalDate fecha;
    private String descripcion;
    private VehiculoDTO vehiculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
}
