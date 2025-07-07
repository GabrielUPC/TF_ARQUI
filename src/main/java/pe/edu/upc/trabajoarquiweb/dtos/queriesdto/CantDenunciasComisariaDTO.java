package pe.edu.upc.trabajoarquiweb.dtos.queriesdto;

public class CantDenunciasComisariaDTO {
    private String nombre;
    private int denunciasporcomisaria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDenunciasporcomisaria() {
        return denunciasporcomisaria;
    }

    public void setDenunciasporcomisaria(int denunciasporcomisaria) {
        this.denunciasporcomisaria = denunciasporcomisaria;
    }
    
}
