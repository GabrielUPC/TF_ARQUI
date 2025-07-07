package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.denuncia.DenunciaDTO;

import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.DenunciaEstadoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Denuncia;

import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDenunciaService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/denuncias")
@SecurityRequirement(name = "bearerAuth")

public class DenunciaController {

    @Autowired//Injeccion de dependencias
    private IDenunciaService dS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<DenunciaDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DenunciaDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Denuncia a = m.map(dto, Denuncia.class);
        dS.insert(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Denuncia a = m.map(dto, Denuncia.class);
        dS.update(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }



    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public DenunciaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        DenunciaDTO dto = m.map(dS.searchId(id), DenunciaDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscar/{id}")
    public List<DenunciaDTO> buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return dS.buscarDenunciaPorId(id).stream()
                .map(x -> m.map(x, DenunciaDTO.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscarporestado")
    public List<DenunciaEstadoDTO> buscarporestado(@RequestParam String estado) {
        List<String[]> filaLista=dS.buscarPorEstado(estado);
        List<DenunciaEstadoDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            DenunciaEstadoDTO dto=new DenunciaEstadoDTO();
            dto.setId(Integer.parseInt(columna[0]));
            dto.setComisaria(Integer.parseInt(columna[1]));
            dto.setEstado(columna[2]);
            dto.setMotivo(columna[3]);
            dto.setDescripcion(columna[4]);
            dto.setVehiculo(columna[5]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }



}
