package pe.edu.upc.trabajoarquiweb.controllers;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.ReclamoResueltosDTO;
import pe.edu.upc.trabajoarquiweb.dtos.reclamo.MisReclamosDTO;
import pe.edu.upc.trabajoarquiweb.dtos.reclamo.ReclamoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Reclamo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IReclamoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamos")
@SecurityRequirement(name = "bearerAuth")

public class ReclamoController {
    @Autowired
    private IReclamoService rS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<ReclamoDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReclamoDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo a = m.map(dto, Reclamo.class);
        rS.insert(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ReclamoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamo a = m.map(dto, Reclamo.class);
        rS.update(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reclamossinresolver")
    public List<ReclamoResueltosDTO> reclamossinresolver() {
        List<String[]> filaLista = rS.reclamosinresolver();
        List<ReclamoResueltosDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            ReclamoResueltosDTO dto = new ReclamoResueltosDTO();
            dto.setFecha(LocalDate.parse(columna[0]));
            dto.setId(Integer.parseInt(columna[1]));
            dto.setUsuario(Integer.parseInt(columna[2]));
            dto.setResuelto(Boolean.parseBoolean(columna[3]));
            dto.setAsunto(columna[4]);
            dto.setDescripcion(columna[5]);
            dtoLista.add(dto);
        }
        return dtoLista;

    }

    @GetMapping("/misreclamos") //Leslie
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<List<MisReclamosDTO>> listarMisReclamos() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Reclamo> reclamos = rS.listarReclamosPorUsername(username);
        List<MisReclamosDTO> dtos = reclamos.stream().map(reclamo -> {
            MisReclamosDTO dto = new MisReclamosDTO();
            dto.setAsunto(reclamo.getAsunto());
            dto.setFecha(reclamo.getFecha());
            dto.setDescripcion(reclamo.getDescripcion());
            dto.setResuelto(reclamo.getResuelto());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ReclamoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ReclamoDTO dto = m.map(rS.searchId(id), ReclamoDTO.class);
        return dto;
    }

}