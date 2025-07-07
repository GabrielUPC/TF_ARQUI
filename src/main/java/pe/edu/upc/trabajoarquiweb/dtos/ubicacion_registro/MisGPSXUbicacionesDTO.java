package pe.edu.upc.trabajoarquiweb.dtos.ubicacion_registro;

import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.MisVehiculosDTO;

public class MisGPSXUbicacionesDTO {
    private String numeroSerie;
    private MisVehiculosDTO vehiculo;

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public MisVehiculosDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(MisVehiculosDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
}
