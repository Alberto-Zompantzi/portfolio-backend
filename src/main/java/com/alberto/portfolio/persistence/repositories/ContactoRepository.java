package com.alberto.portfolio.persistence.repositories;

import com.alberto.portfolio.persistence.entities.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //Para indicar que esta interfaz es la encargada de comunicarse con la bd
public interface ContactoRepository extends JpaRepository<Contacto, Long>{
    //esta herencia me da los métodos .save(), .findAll(), .findById() etc...
}
