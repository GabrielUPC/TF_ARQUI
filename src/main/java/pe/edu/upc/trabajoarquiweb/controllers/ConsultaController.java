package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.consulta.MisConsultasDTO;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.CantidadConsultasPorUsuarioDTO;
import pe.edu.upc.trabajoarquiweb.dtos.consulta.ConsultaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Consulta;
import pe.edu.upc.trabajoarquiweb.serviceImplements.ConsultaServiceImplement;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IConsultaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearerAuth")

public class ConsultaController {

    @Autowired
    private IConsultaService cS;
    @Autowired
    private ConsultaServiceImplement consultaServiceImplement;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<ConsultaDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultaDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public ConsultaDTO insertar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta c = m.map(dto, Consulta.class);
        Consulta saved = cS.insert(c);
        return m.map(saved, ConsultaDTO.class);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ConsultaDTO dto) {
        ModelMapper m = new ModelMapper();
        Consulta a = m.map(dto, Consulta.class);
        cS.update(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/cantidadconsultas")
    public List<CantidadConsultasPorUsuarioDTO> cantidadConsultasPorUsuario() {
        List<String[]> lista = cS.cantidadConsultasPorUsuario();
        List<CantidadConsultasPorUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CantidadConsultasPorUsuarioDTO dto = new CantidadConsultasPorUsuarioDTO();
            dto.setId(Integer.parseInt(columna[0]));
            dto.setNombres(columna[1]);
            dto.setApellidos(columna[2]);
            dto.setCantidadConsultas(Integer.parseInt(columna[3]));

            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/misconsultas")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<List<MisConsultasDTO>> listarMisConsultas() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Consulta> consultas = consultaServiceImplement.listarConsultasPorUsername(username);
        List<MisConsultasDTO> dtos = consultas.stream().map(c -> {
            MisConsultasDTO dto = new MisConsultasDTO();
            dto.setConsulta(c.getConsulta());
            dto.setFecha(c.getFecha());
            dto.setHora(c.getHora());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ConsultaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ConsultaDTO dto = m.map(cS.searchId(id), ConsultaDTO.class);
        return dto;
    }

}
