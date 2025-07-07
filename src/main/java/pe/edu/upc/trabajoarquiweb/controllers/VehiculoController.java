package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.MisVehiculosDTO;
import pe.edu.upc.trabajoarquiweb.dtos.vehiculo.VehiculoDTO;
import pe.edu.upc.trabajoarquiweb.entities.Vehiculo;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IVehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")
@SecurityRequirement(name = "bearerAuth")
public class VehiculoController {
    @Autowired//Injeccion de dependencias
    private IVehiculoService vS;

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping
    public List<VehiculoDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VehiculoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo a = m.map(dto, Vehiculo.class);
        vS.insert(a);
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo a = m.map(dto, Vehiculo.class);
        vS.update(a);
    }
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @DeleteMapping("/{placa}")
    public void eliminar(@PathVariable("placa") String placa) {
        vS.delete(placa);
    }

    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    @GetMapping("/{placa}")
    public VehiculoDTO listarPlaca(@PathVariable("placa") String placa) {
        ModelMapper m = new ModelMapper();
        VehiculoDTO dto = m.map(vS.buscarPorPlaca(placa), VehiculoDTO.class);
        return dto;
    }

    @GetMapping("/misvehiculos")
    @PreAuthorize("hasAuthority('CLIENTE') or hasAuthority('ADMIN')")
    public ResponseEntity<List<MisVehiculosDTO>> listarMisVehiculos() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Vehiculo> vehiculos = vS.listarVehiculosPorUsername(username);
        // Convertir entidad a DTO manualmente
        List<MisVehiculosDTO> dtos = vehiculos.stream().map(v -> {
            MisVehiculosDTO dto = new MisVehiculosDTO();
            dto.setPlaca(v.getPlaca());
            dto.setColor(v.getColor());
            dto.setMarca(v.getMarca());
            dto.setModelo(v.getModelo());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

}
