package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Comisaria")
public class Comisaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre",nullable = false, length = 50)
    private String nombre;
    @Column(name = "direccion",nullable = false, length = 50)
    private String direccion;
    @Column(name = "distrito",nullable = false, length = 50)
    private String distrito;
    @Column(name = "telefono",nullable = false, length = 9)
    private int telefono;

    public Comisaria() {}

    public Comisaria(int id, String nombre, String direccion, String distrito, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}