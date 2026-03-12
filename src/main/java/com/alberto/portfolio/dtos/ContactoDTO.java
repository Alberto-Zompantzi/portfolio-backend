package com.alberto.portfolio.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactoDTO {//Este objeto es el que recibe los datos del Frontend
    //No pongo ID porque lo gestiona el servidor

    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Formato de email inválido.")
    private String email;

    private String asunto;

    @NotBlank(message = "El mensaje no puede estar vacío.")
    @Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres.")
    private String mensaje;
}
