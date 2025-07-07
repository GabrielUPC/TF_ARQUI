package pe.edu.upc.trabajoarquiweb.dtos.queriesdto;

public class NVehiculosUsuarioDTO {
    private int id;
    private String nombres;
    private int listaVehiculosPorUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getListaVehiculosPorUsuario() {
        return listaVehiculosPorUsuario;
    }

    public void setListaVehiculosPorUsuario(int listaVehiculosPorUsuario) {
        this.listaVehiculosPorUsuario = listaVehiculosPorUsuario;
    }
}
