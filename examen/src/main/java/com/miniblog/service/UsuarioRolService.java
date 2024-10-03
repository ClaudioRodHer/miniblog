package com.miniblog.service;

import com.miniblog.model.UsuarioRol;
import com.miniblog.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;

    @Autowired
    public UsuarioRolService(UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRolRepository = usuarioRolRepository;
    }

    // Obtener todas las relaciones usuario-rol
    public List<UsuarioRol> getAllUsuarioRoles() {
        return usuarioRolRepository.findAll();
    }

    // Obtener una relación usuario-rol por ID
    public Optional<UsuarioRol> getUsuarioRolById(Long id) {
        return usuarioRolRepository.findById(id);
    }

    // Crear una nueva relación usuario-rol
    public UsuarioRol createUsuarioRol(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    // Eliminar una relación usuario-rol
    public void deleteUsuarioRol(Long id) {
        usuarioRolRepository.deleteById(id);
    }
}
