package com.miniblog.service;

import com.miniblog.model.Publicacion;
import com.miniblog.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    // Obtener todas las publicaciones
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    // Obtener una publicación por ID
    public Optional<Publicacion> getPublicacionById(Long id) {
        return publicacionRepository.findById(id);
    }

    // Crear una nueva publicación
    public Publicacion createPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    // Actualizar una publicación
    public Publicacion updatePublicacion(Long id, Publicacion publicacionDetails) {
        return publicacionRepository.findById(id)
            .map(publicacion -> {
                publicacion.setCuerpo(publicacionDetails.getCuerpo());
                return publicacionRepository.save(publicacion);
            }).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
    }

    // Eliminar una publicación
    public void deletePublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }
}
