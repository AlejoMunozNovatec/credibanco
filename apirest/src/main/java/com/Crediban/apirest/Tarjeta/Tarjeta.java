package com.Crediban.apirest.Tarjeta;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;

    @Basic
    private String numeroTarjeta;
    private String nombreTitular;
    private Date fechaCreacion;
    private Date fechaVencimiento;
    private double saldo;
    private boolean activada;
    private boolean bloqueada;

    // Constructor, Getters y Setters
}
