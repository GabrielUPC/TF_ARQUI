package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.CantDenunciasComisariaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.comisaria.ComisariaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Comisaria;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IComisariaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comisarias")
@SecurityRequirement(name = "bearerAuth")

public class ComisariaController {

    @Autowired//Injeccion de dependencias
    private IComisariaService cS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<ComisariaDTO> listar() {
        return cS.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComisariaDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody ComisariaDTO dto) {
        ModelMapper m = new ModelMapper();
        Comisaria a = m.map(dto, Comisaria.class);
        cS.insert(a);
    }


    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody ComisariaDTO dto) {
        ModelMapper m = new ModelMapper();
        Comisaria a = m.map(dto, Comisaria.class);
        cS.update(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/buscarDistrito")
    public List<ComisariaDTO> buscarComisariaPorDistrito(@RequestParam String distrito) {
        List<String[]> filaLista = cS.buscarComisariaPorDistrito(distrito);
        List<ComisariaDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            ComisariaDTO dto = new ComisariaDTO();
            dto.setId(Integer.parseInt(columna[0]));
            dto.setTelefono(Integer.parseInt(columna[1]));
            dto.setDireccion(columna[2]);
            dto.setDistrito(columna[3]);
            dto.setNombre(columna[4]);
            dtoLista.add(dto);
        }
        return dtoLista;

    }

    @GetMapping("/denunciasxcomisaria")
    public List<CantDenunciasComisariaDTO> Cantidaddenunciasxcomisaria() {
        List<String[]> filaLista = cS.cantidaddenunciasporcomisaria();
        List<CantDenunciasComisariaDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            CantDenunciasComisariaDTO dto = new CantDenunciasComisariaDTO();
            dto.setNombre(columna[0]);
            dto.setDenunciasporcomisaria(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;

    }


    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ComisariaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ComisariaDTO dto = m.map(cS.searchId(id), ComisariaDTO.class);
        return dto;
    }

}