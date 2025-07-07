package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    private String placa;
    @Column(name = "color", nullable = false,length = 20)
    private String color;
    @Column(name = "marca", nullable = false,length = 20)
    private String marca;
    @Column(name = "modelo", nullable = false,length = 20)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false)
    private Usuario usuario;
    public Vehiculo() {}

    public Vehiculo(String placa, String color, String marca, String modelo, Usuario usuario) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.usuario = usuario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
