package pe.edu.upc.trabajoarquiweb.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "texto", nullable = false,length = 100000)
    private String texto;

    @OneToOne
    @JoinColumn(name = "idConsulta")
    private Consulta consulta;
    public Respuesta() {}

    public Respuesta(int id, String texto, Consulta consulta) {
        this.id = id;
        this.texto = texto;
        this.consulta = consulta;
    }

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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
