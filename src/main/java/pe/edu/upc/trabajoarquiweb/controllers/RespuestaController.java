package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.respuesta.RespuestaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;
import pe.edu.upc.trabajoarquiweb.entities.Respuesta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRepuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearerAuth")

public class  RespuestaController {

    @Autowired
    private IRepuestaService rrS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<RespuestaDTO> listar() {
        return rrS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }


    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public RespuestaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RespuestaDTO dto = m.map(rrS.searchId(id), RespuestaDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody RespuestaDTO dto) {
        ModelMapper m = new ModelMapper();

        // Mapea lo básico (id, texto) SIN consulta
        Respuesta r = m.map(dto, Respuesta.class);

        // ⚠️ Ajuste manual: solo seteamos el ID de la consulta
        Consulta c = new Consulta();
        c.setId(dto.getConsulta().getId());
        r.setConsulta(c);

        rrS.insert(r);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody RespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        Respuesta a = m.map(dto, Respuesta.class);
        rrS.update(a);
    }


    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping
    public void eliminar(@PathVariable("id") int id) {
        rrS.delete(id);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/consulta/{consultaId}")
    public RespuestaDTO buscarPorConsulta(@PathVariable("consultaId") int consultaId) {
        ModelMapper m = new ModelMapper();
        return m.map(rrS.findByConsultaId(consultaId), RespuestaDTO.class);
    }
}
