package pe.edu.upc.trabajoarquiweb.dtos.ubicacion_registro;

import java.time.LocalDate;
import java.time.LocalTime;

public class UbicacionDTO {
    private String latitud;
    private String longitud;
    private LocalDate fecha;
    private LocalTime hora;
    private MisGPSXUbicacionesDTO gps;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public MisGPSXUbicacionesDTO getGps() {
        return gps;
    }

    public void setGps(MisGPSXUbicacionesDTO gps) {
        this.gps = gps;
    }
}
