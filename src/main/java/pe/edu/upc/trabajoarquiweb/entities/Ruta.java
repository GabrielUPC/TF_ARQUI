package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Ruta")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "origenLatitud", nullable = false, length = 40)
    private String origenLatitud;
    @Column(name = "origenLongitud", nullable = false, length = 40)
    private String origenLongitud;
    @Column(name = "destinoLatitud", nullable = false, length = 40)
    private String destinoLatitud;
    @Column(name = "destinoLongitud", nullable = false, length = 40)
    private String destinoLongitud;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "duracion", nullable = false)
    private LocalTime duracion;
    @Column(name = "distancia", nullable = false)
    private int distancia;

    @ManyToOne
    @JoinColumn(name = "placaV")
    private Vehiculo vehiculo;

    public Ruta() {}

    public Ruta(int id, String origenLatitud, String origenLongitud, String destinoLatitud, String destinoLongitud, LocalDate fecha, LocalTime duracion, int distancia, Vehiculo vehiculo) {
        this.id = id;
        this.origenLatitud = origenLatitud;
        this.origenLongitud = origenLongitud;
        this.destinoLatitud = destinoLatitud;
        this.destinoLongitud = destinoLongitud;
        this.fecha = fecha;
        this.distancia = distancia;
        this.vehiculo = vehiculo;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigenLatitud() {
        return origenLatitud;
    }

    public void setOrigenLatitud(String origenLatitud) {
        this.origenLatitud = origenLatitud;
    }

    public String getOrigenLongitud() {
        return origenLongitud;
    }

    public void setOrigenLongitud(String origenLongitud) {
        this.origenLongitud = origenLongitud;
    }

    public String getDestinoLatitud() {
        return destinoLatitud;
    }

    public void setDestinoLatitud(String destinoLatitud) {
        this.destinoLatitud = destinoLatitud;
    }

    public String getDestinoLongitud() {
        return destinoLongitud;
    }

    public void setDestinoLongitud(String destinoLongitud) {
        this.destinoLongitud = destinoLongitud;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
