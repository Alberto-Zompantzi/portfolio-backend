package com.alberto.portfolio.services.impl;

import com.alberto.portfolio.dtos.ContactoDTO;
import com.alberto.portfolio.persistence.entities.Contacto;
import com.alberto.portfolio.persistence.repositories.ContactoRepository;
import com.alberto.portfolio.services.ContactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //La marco como componente de servicio para que la use el Controller
@RequiredArgsConstructor // Lombok inyecta el repositorio automáticamente
//Implemento de la interfaz ContactoService para escribir la implementación
public class ContactoServiceImpl implements ContactoService {
    //Tomo el DTO (los datos del front) y creo una
    // Entity (los datos de la base de datos) para guardarla.

    //creo una instancia para conectar con la bd
    private final ContactoRepository contactoRepository;

    @Override
    public Contacto guardarMensaje(ContactoDTO dto){
        //Mapeo manual sin librerías externas
        //Creo un objeto que representa una fila en mi db
        Contacto entidad = new Contacto();
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setAsunto(dto.getAsunto());
        entidad.setMensaje(dto.getMensaje());

        //Paso la entidad lista el repositorio, Spring Data JPA genera por detrás
        //el comando SQL INSERT INTO contactos
        return contactoRepository.save(entidad);
    }
}
