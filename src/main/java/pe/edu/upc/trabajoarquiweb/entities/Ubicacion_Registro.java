package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Ubicacion-Registro")
public class Ubicacion_Registro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "latitud", nullable = false, length = 40)
    private String latitud;
    @Column(name = "longitud", nullable = false, length = 40)
    private String longitud;
    @Column(name = "fecha",nullable = false)
    private LocalDate fecha;
    @Column(name = "hora", nullable = false)
    private LocalTime hora;
    @ManyToOne
    @JoinColumn(name = "idD")
    private Dispositivo_GPS disGPS;

    public Ubicacion_Registro() {}

    public Ubicacion_Registro(int id, String latitud, String longitud, LocalDate fecha, LocalTime hora, Dispositivo_GPS disGPS) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
        this.hora = hora;
        this.disGPS = disGPS;
    }

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

    public Dispositivo_GPS getDisGPS() {
        return disGPS;
    }

    public void setDisGPS(Dispositivo_GPS disGPS) {
        this.disGPS = disGPS;
    }
}
