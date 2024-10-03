package com.miniblog.service;

import com.miniblog.model.Rol;
import com.miniblog.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    // Obtener todos los roles
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    // Obtener un rol por ID
    public Optional<Rol> getRolById(Long id) {
        return rolRepository.findById(id);
    }

    // Crear un nuevo rol
    public Rol createRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Actualizar un rol
    public Rol updateRol(Long id, Rol rolDetails) {
        return rolRepository.findById(id)
            .map(rol -> {
                rol.setTipo(rolDetails.getTipo());
                return rolRepository.save(rol);
            }).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    // Eliminar un rol
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
