package pe.edu.upc.trabajoarquiweb.dtos.dispostivo_gps;

import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.MisVehiculosDTO;

import java.time.LocalDate;

public class MisGPSDTO {
    private String numeroSerie;
    private double precio;
    private LocalDate fechaAdquisicion;
    private MisVehiculosDTO vehiculo;

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

    public MisVehiculosDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(MisVehiculosDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
}
