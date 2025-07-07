package pe.edu.upc.trabajoarquiweb.dtos.queriesdto;


public class DenunciaEstadoDTO {
    private int id;
    private String descripcion;
    private String motivo;
    private String estado;
    private int comisaria;
    private String vehiculo;

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

    public int getComisaria() {
        return comisaria;
    }

    public void setComisaria(int comisaria) {
        this.comisaria = comisaria;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
}
