package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.dispostivo_gps.Dispositivo_GPSDTO;
import pe.edu.upc.trabajoarquiweb.dtos.dispostivo_gps.MisGPSDTO;
import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.MisVehiculosDTO;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IDispositivo_GPSService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/gps")
@SecurityRequirement(name = "bearerAuth")

public class Dispositivo_GPSController {
    @Autowired//Injeccion de dependencias
    private IDispositivo_GPSService dS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<Dispositivo_GPSDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Dispositivo_GPSDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody Dispositivo_GPSDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo_GPS a = m.map(dto, Dispositivo_GPS.class);
        dS.insert(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody Dispositivo_GPSDTO dto) {
        ModelMapper m = new ModelMapper();
        Dispositivo_GPS a = m.map(dto, Dispositivo_GPS.class);
        dS.update(a);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }

    @GetMapping("/misgps")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<List<MisGPSDTO>> listarMisGPS() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Dispositivo_GPS> gpsList =dS.listarGPSPorUsername(username);
        List<MisGPSDTO> dtoList = gpsList.stream().map(gps -> {
            MisGPSDTO dto = new MisGPSDTO();
            dto.setNumeroSerie(gps.getNumeroSerie());
            dto.setPrecio(gps.getPrecio());
            dto.setFechaAdquisicion(gps.getFechaAdquisicion());
            // Mapear también el vehículo asociado como MisVehiculosDTO
            Vehiculo v = gps.getVehiculo();
            MisVehiculosDTO vehiculoDTO = new MisVehiculosDTO();
            vehiculoDTO.setPlaca(v.getPlaca());
            vehiculoDTO.setColor(v.getColor());
            vehiculoDTO.setMarca(v.getMarca());
            vehiculoDTO.setModelo(v.getModelo());
            dto.setVehiculo(vehiculoDTO);
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public Dispositivo_GPSDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Dispositivo_GPSDTO dto = m.map(dS.searchId(id), Dispositivo_GPSDTO.class);
        return dto;
    }
}
