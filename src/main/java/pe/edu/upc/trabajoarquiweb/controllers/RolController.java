package pe.edu.upc.trabajoarquiweb.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajoarquiweb.dtos.denuncia.DenunciaDTO;
import pe.edu.upc.trabajoarquiweb.dtos.rol.RolDTO;
import pe.edu.upc.trabajoarquiweb.dtos.usuario.UsuarioDTO2;
import pe.edu.upc.trabajoarquiweb.entities.Rol;
import pe.edu.upc.trabajoarquiweb.serviceInterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Rol")
@SecurityRequirement(name = "bearerAuth")

public class RolController {

    @Autowired//Injeccion de dependencias
    private IRolService rS;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<RolDTO> listarRoles() {
        List<Rol> lista = rS.list();
        ModelMapper m = new ModelMapper();

        return lista.stream().map(r -> {
            RolDTO dto = new RolDTO(r.getId(), r.getRol());
            dto.setUsuario(m.map(r.getUser(), UsuarioDTO2.class)); // 👈 Aquí se asigna el usuario
            return dto;
        }).collect(Collectors.toList());
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rS.insert(a);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody DenunciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.update(r);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/cambiar-rol/{id}")
    public void cambiarRol(@PathVariable("id") Long id, @RequestBody String nuevoRol) {
        rS.cambiarRol(id, nuevoRol);
    }

}
