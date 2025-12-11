package com.HandlerException.ErrorsController.Domicilio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Domicilio {

    @Size(min = 3, message = "la calle debe ser mayor que 3 caracteres")
    @NotBlank(message = "la calle no debe estar vacia")
    public String calle;
    @Size(min = 3, message = "la colonia debe tener mas de 3 caracteres")
    @NotBlank(message = "la colonia no debe estar vacia")
    public String colonia;

    public Domicilio() {}

    public Domicilio(String calle, String colonia) {
        this.calle = calle;
        this.colonia = colonia;
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getColonia() { return colonia; }
    public void  setColonia(String colonia) { this.colonia = this.colonia; }
}

