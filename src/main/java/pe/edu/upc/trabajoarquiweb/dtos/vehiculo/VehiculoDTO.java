package pe.edu.upc.trabajoarquiweb.dtos.vehiculo;

import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO2;

public class VehiculoDTO {
    private String placa;

    private String color;

    private String marca;

    private String modelo;

    private UsuarioDTO2 usuario;

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

    public UsuarioDTO2 getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO2 usuario) {
        this.usuario = usuario;
    }
}
