package com.HandlerException.ErrorsController.User;

import com.HandlerException.ErrorsController.Domicilio.Domicilio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class User {

    private UUID uuid;
    @NotBlank(message = "el nombre no debe ir vacio")
    @Size(min = 3, message = "debes agregar un nombre mayor a 3 caracters")
    public String nombre;
    public String edad;

    @Valid
    public Domicilio domicilio;

    public User(UUID uuid, String nombre, String edad, Domicilio domicilio) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
    }

    public UUID getUuid() { return uuid;}
    public void setUuid(UUID uuid) { this.uuid = uuid; }

    public String getNombre() { return  nombre; }
    public void setNombre (String nombre) { this.nombre = nombre; }

    public String getEdad() { return edad; }
    public void setEdad() { this.edad = edad; }
}
