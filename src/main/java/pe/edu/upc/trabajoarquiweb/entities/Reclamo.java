package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Reclamo")
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "asunto", nullable = false, length = 20)
    private String asunto;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @Column(name = "Resuelto", nullable = false)
    private Boolean resuelto;


    @ManyToOne
    @JoinColumn(name = "idUser")
    private Usuario usuario;

    public Reclamo() {}

    public Reclamo(int id, String asunto, LocalDate fecha, String descripcion, Boolean resuelto, Usuario usuario) {
        this.id = id;
        this.asunto = asunto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.resuelto = resuelto;
        this.usuario = usuario;
    }

    public Boolean getResuelto() {
        return resuelto;
    }

    public void setResuelto(Boolean resuelto) {
        this.resuelto = resuelto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
