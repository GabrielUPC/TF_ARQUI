package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.respuesta.RespuestaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.ubicacion_registro.MisGPSXUbicacionesDTO;
import pe.edu.upc.trabajoarquiweb.dtos.ubicacion_registro.UbicacionDTO;
import pe.edu.upc.trabajoarquiweb.dtos.ubicacion_registro.Ubicacion_RegistroDTO;
import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.MisVehiculosDTO;
import pe.edu.upc.trabajoarquiweb.entities.Dispositivo_GPS;
import pe.edu.upc.trabajoarquiweb.entities.Ubicacion_Registro;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IUbicacion_RegistroService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/ubicaciones")
@SecurityRequirement(name = "bearerAuth")

public class Ubicacion_RegistroController {
    @Autowired//Injeccion de dependencias
    private IUbicacion_RegistroService ruS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<Ubicacion_RegistroDTO> listar() {
        return ruS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Ubicacion_RegistroDTO.class);
        }).collect(Collectors.toList());

    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody Ubicacion_RegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion_Registro u = m.map(dto, Ubicacion_Registro.class);
        ruS.insert(u);
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody Ubicacion_RegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion_Registro u = m.map(dto, Ubicacion_Registro.class);
        ruS.update(u);
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        ruS.delete(id);
    }

    @GetMapping("/misubicaciones")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<List<UbicacionDTO>> listarMisUbicaciones() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Ubicacion_Registro> ubicaciones =
                ruS.listarUbicacionesPorUsername(username);
        List<UbicacionDTO> dtos = ubicaciones.stream().map(u -> {
            UbicacionDTO dto = new UbicacionDTO();
            dto.setLatitud(u.getLatitud());
            dto.setLongitud(u.getLongitud());
            dto.setFecha(u.getFecha());
            dto.setHora(u.getHora());
            Dispositivo_GPS gps = u.getDisGPS();
            Vehiculo v = gps.getVehiculo();
            // Vehículo DTO
            MisVehiculosDTO vehiculoDTO = new MisVehiculosDTO();
            vehiculoDTO.setPlaca(v.getPlaca());
            vehiculoDTO.setColor(v.getColor());
            vehiculoDTO.setMarca(v.getMarca());
            vehiculoDTO.setModelo(v.getModelo());
            // GPS DTO renombrado
            MisGPSXUbicacionesDTO gpsDTO = new MisGPSXUbicacionesDTO();
            gpsDTO.setNumeroSerie(gps.getNumeroSerie());
            gpsDTO.setVehiculo(vehiculoDTO);
            dto.setGps(gpsDTO);
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public Ubicacion_RegistroDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Ubicacion_RegistroDTO dto = m.map(ruS.searchId(id), Ubicacion_RegistroDTO.class);
        return dto;
    }

}
