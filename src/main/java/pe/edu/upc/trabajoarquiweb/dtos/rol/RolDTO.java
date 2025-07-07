package pe.edu.upc.trabajoarquiweb.dtos.rol;

import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO2;

public class RolDTO {


    private Long id;

    private String rol;

    private UsuarioDTO2 usuario;

    public RolDTO(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public UsuarioDTO2 getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO2 usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
