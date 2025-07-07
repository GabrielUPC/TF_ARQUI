package pe.edu.upc.trabajoarquiweb.dtos.ubicacion_registro;

import pe.edu.upc.trabajoarquiweb.dtos.dispostivo_gps.Dispositivo_GPSDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ubicacion_RegistroDTO {

    private int id;
    private String latitud;
    private String longitud;
    private LocalDate fecha;
    private LocalTime hora;
    private Dispositivo_GPSDTO disGPS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Dispositivo_GPSDTO getDisGPS() {
        return disGPS;
    }

    public void setDisGPS(Dispositivo_GPSDTO disGPS) {
        this.disGPS = disGPS;
    }
}
