package pe.edu.upc.trabajoarquiweb.dtos.dispostivo_gps;

import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.VehiculoDTO;

import java.time.LocalDate;

public class Dispositivo_GPSDTO {
    private int id;
    private String numeroSerie;
    private double precio;
    private LocalDate fechaAdquisicion;

    private VehiculoDTO vehiculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
}
