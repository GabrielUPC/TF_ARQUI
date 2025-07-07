package pe.edu.upc.trabajoarquiweb.dtos.denuncia;

import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.VehiculoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Comisaria;

public class DenunciaDTO {

    private int id;
    private String descripcion;
    private String motivo;
    private String estado;
    private Comisaria comisaria;
    private VehiculoDTO vehiculo;

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

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
}
