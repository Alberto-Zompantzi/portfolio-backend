package com.alberto.portfolio.services;

import com.alberto.portfolio.dtos.ContactoDTO;
import com.alberto.portfolio.persistence.entities.Contacto;

//Defino qué puede hacer mi sistema, sin implementar nada aún

public interface ContactoService {
    Contacto guardarMensaje(ContactoDTO contactoDTO);
}
