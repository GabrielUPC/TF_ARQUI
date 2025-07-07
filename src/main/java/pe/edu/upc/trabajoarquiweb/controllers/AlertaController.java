package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.alerta.AlertaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.alerta.MisAlertasDTO;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.AlertaQuerieDTO;
import pe.edu.upc.trabajoarquiweb.dtos.queriesdto.UsuarioConTotalAlertasDTO;
import pe.edu.upc.trabajoarquiweb.entities.Alerta;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IAlertaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/alertas")
@SecurityRequirement(name = "bearerAuth")

public class AlertaController {
    @Autowired//Injeccion de dependencias
    private IAlertaService aS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<AlertaDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlertaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta a = m.map(dto, Alerta.class);
        aS.insert(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta a = m.map(dto,Alerta.class);
        aS.update(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        aS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/usuarios_maslertas")
    public List<UsuarioConTotalAlertasDTO> listarUsuariosMaslertas() {
        List<String[]> filaLista=aS.usersMoreAlert();
        List<UsuarioConTotalAlertasDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            UsuarioConTotalAlertasDTO dto=new UsuarioConTotalAlertasDTO();
            dto.setNombreCompleto(columna[0]);
            dto.setTotalAlertas(Long.parseLong(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/alertas_periodo")
    public List<AlertaQuerieDTO> alertasenperiodo(@RequestParam LocalDate fecha1, LocalDate fecha2) {
        List<String[]> filaLista=aS.fechaAlertmore(fecha1,fecha2);
        List<AlertaQuerieDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            AlertaQuerieDTO dto=new AlertaQuerieDTO();
            dto.setFecha(LocalDate.parse(columna[0]));
            dto.setId(Integer.parseInt(columna[1]));
            dto.setAsunto(columna[2]);
            dto.setDescripcion(columna[3]);
            dto.setVehiculo(columna[4]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/alertas_vehiculo")
    public List<AlertaQuerieDTO> alertaporvehiculo(@RequestParam String placa) {
        List<String[]> filaLista=aS.placaAlert(placa);
        List<AlertaQuerieDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            AlertaQuerieDTO dto=new AlertaQuerieDTO();
            dto.setFecha(LocalDate.parse(columna[0]));
            dto.setId(Integer.parseInt(columna[1]));
            dto.setAsunto(columna[2]);
            dto.setDescripcion(columna[3]);
            dto.setVehiculo(columna[4]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/misalertas")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<List<MisAlertasDTO>> listarMisAlertas() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<MisAlertasDTO> alertas = aS.listarAlertasPorUsername(username);
        return ResponseEntity.ok(alertas);
    }


    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public AlertaDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AlertaDTO dto = m.map(aS.searchId(id), AlertaDTO.class);
        return dto;
    }
}
