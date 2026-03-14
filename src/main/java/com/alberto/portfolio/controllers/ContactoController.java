package com.alberto.portfolio.controllers;

import com.alberto.portfolio.dtos.ContactoDTO;
import com.alberto.portfolio.persistence.entities.Contacto;
import com.alberto.portfolio.services.ContactoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Para manejar datos JSON
@RequestMapping("/api/v1/contactos") //Defino mi URL versionandola
@RequiredArgsConstructor // Lombok inyecta el repositorio automáticamente sin constructores manuales
@CrossOrigin(origins = "*")// Permite que React (puerto 3000/5173) se comunique con el Back (8080)
public class ContactoController {
    //Endpoint
    //Recibo el JSON de React y válido que el email sea real y no falten datos
    //Maneja el protocolo HTTP. Sabe qué responder sitodo sale bien (201 Created)
    // o si el usuario envió algo mal (400 Bad Request).

    private final ContactoService contactoService;

    @PostMapping      //@Valid revisa las reglas que puse en DTO
    public ResponseEntity<Contacto> crearContacto(@Valid @RequestBody ContactoDTO contactoDTO) {
        //Se llama al servicio para procesar y guardar
        Contacto nuevoContacto = contactoService.guardarMensaje(contactoDTO);

        //Devuelvo el objeto creado con un status 201(Created)
        return new ResponseEntity<Contacto>(nuevoContacto, HttpStatus.CREATED);

    }
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Servidor despierto y listo.");
    }
}
