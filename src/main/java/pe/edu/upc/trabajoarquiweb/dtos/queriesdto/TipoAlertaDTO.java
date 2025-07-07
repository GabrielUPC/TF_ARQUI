package pe.edu.upc.trabajoarquiweb.dtos.queriesdto;

public class TipoAlertaDTO {
    private String tipoAlerta;
    private Long total;

    // Constructor vacío
    public TipoAlertaDTO() {
    }

    // Constructor con parámetros
    public TipoAlertaDTO(String tipoAlerta, Long total) {
        this.tipoAlerta = tipoAlerta;
        this.total = total;
    }

    // Getters y setters
    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
