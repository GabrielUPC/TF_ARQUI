package pe.edu.upc.trabajoarquiweb.dtos.respuesta;

import pe.edu.upc.trabajoarquiweb.dtos.consulta.ConsultaDTO;

public class RespuestaDTO {

    private int id;
    private String texto;
    private ConsultaDTO consulta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ConsultaDTO getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaDTO consulta) {
        this.consulta = consulta;
    }
}
