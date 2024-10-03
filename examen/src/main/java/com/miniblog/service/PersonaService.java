package com.miniblog.service;

import com.miniblog.model.Persona;
import com.miniblog.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Obtener todas las personas
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Obtener una persona por ID
    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    // Crear una nueva persona
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    // Actualizar una persona
    public Persona updatePersona(Long id, Persona personaDetails) {
        return personaRepository.findById(id)
            .map(persona -> {
                persona.setNombre(personaDetails.getNombre());
                persona.setApellido(personaDetails.getApellido());
                persona.setUsuario(personaDetails.getUsuario());
                return personaRepository.save(persona);
            }).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    // Eliminar una persona
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
