package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Dispositivo_GPS")
public class Dispositivo_GPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numero_serie", nullable = false,length = 6)
    private String numeroSerie;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "fechaAdquisicion", nullable = false)
    private LocalDate fechaAdquisicion;

    @OneToOne
    @JoinColumn(name = "placaV")
    private Vehiculo vehiculo;

    public Dispositivo_GPS() {}

    public Dispositivo_GPS(int id, String numeroSerie, double precio, LocalDate fechaAdquisicion, Vehiculo vehiculo) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.fechaAdquisicion = fechaAdquisicion;
        this.vehiculo = vehiculo;
    }

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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
