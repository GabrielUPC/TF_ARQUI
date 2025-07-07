package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.RutasperiodoplacaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.ruta.RutaDTO;
import pe.edu.upc.trabajoarquiweb.entities.Ruta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRutaService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rutas")
@SecurityRequirement(name = "bearerAuth")

public class RutaController {

    @Autowired
    private IRutaService rS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<RutaDTO> listar() {
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RutaDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody RutaDTO dto) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(dto, Ruta.class);
        rS.insert(r);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public RutaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RutaDTO dto = m.map(rS.searchId(id), RutaDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody RutaDTO dto) {
        ModelMapper m = new ModelMapper();
        Ruta r = m.map(dto, Ruta.class);
        rS.update(r);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/rutas_periodo_placa")
    public List<RutasperiodoplacaDTO> rutas_periodo_placa(@RequestParam LocalDate fecha1, LocalDate fecha2, String placa) {
        List<String[]> filaLista=rS.RutasenPeriodo(fecha1,fecha2,placa);
        List<RutasperiodoplacaDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            RutasperiodoplacaDTO dto=new RutasperiodoplacaDTO();
            dto.setDistancia(Integer.parseInt(columna[0]));
            dto.setDuracion(LocalTime.parse(columna[1]));
            dto.setFecha(LocalDate.parse(columna[2]));
            dto.setId(Integer.parseInt(columna[3]));
            dto.setDestinoLatitud(columna[4]);
            dto.setDestinoLongitud(columna[5]);
            dto.setOrigenLatitud(columna[6]);
            dto.setOrigenLongitud(columna[7]);
            dto.setPlaca(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
