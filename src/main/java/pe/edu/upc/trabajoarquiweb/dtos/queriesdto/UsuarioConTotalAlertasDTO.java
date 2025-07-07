package pe.edu.upc.trabajoarquiweb.dtos.queriesdto;

public class UsuarioConTotalAlertasDTO {
    private String nombreCompleto;
    private Long totalAlertas;

    // Constructor vacío (necesario para algunas frameworks como Jackson)
    public UsuarioConTotalAlertasDTO() {
    }

    // Constructor con parámetros
    public UsuarioConTotalAlertasDTO(String nombreCompleto, Long totalAlertas) {
        this.nombreCompleto = nombreCompleto;
        this.totalAlertas = totalAlertas;
    }

    // Getters y setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getTotalAlertas() {
        return totalAlertas;
    }

    public void setTotalAlertas(Long totalAlertas) {
        this.totalAlertas = totalAlertas;
    }
}
