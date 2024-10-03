package com.miniblog.controller;

import com.miniblog.model.UsuarioRol;
import com.miniblog.service.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-rol")
public class UsuarioRolController {

    private final UsuarioRolService usuarioRolService;

    @Autowired
    public UsuarioRolController(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    @GetMapping
    public List<UsuarioRol> getAllUsuarioRoles() {
        return usuarioRolService.getAllUsuarioRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> getUsuarioRolById(@PathVariable Long id) {
        return usuarioRolService.getUsuarioRolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioRol createUsuarioRol(@RequestBody UsuarioRol usuarioRol) {
        return usuarioRolService.createUsuarioRol(usuarioRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioRol(@PathVariable Long id) {
        usuarioRolService.deleteUsuarioRol(id);
        return ResponseEntity.noContent().build();
    }
}
