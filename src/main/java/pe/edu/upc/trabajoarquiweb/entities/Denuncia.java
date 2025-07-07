package pe.edu.upc.trabajoarquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Denuncia")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descripcion", nullable = false,length = 250)
    private String descripcion;
    @Column(name = "motivo", nullable = false,length = 30)
    private String motivo;
    @Column(name = "estado", nullable = false,length = 10)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idComisaria")
    private Comisaria comisaria;
    @ManyToOne
    @JoinColumn(name = "placaV")
    private Vehiculo vehiculo;
    public Denuncia() {}

    public Denuncia(int id, String descripcion, String motivo, String estado, Comisaria comisaria, Vehiculo vehiculo) {
        this.id = id;
        this.descripcion = descripcion;
        this.motivo = motivo;
        this.estado = estado;
        this.comisaria = comisaria;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Comisaria getComisaria() {
        return comisaria;
    }

    public void setComisaria(Comisaria comisaria) {
        this.comisaria = comisaria;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
