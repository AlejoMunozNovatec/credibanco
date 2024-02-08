package com.Crediban.apirest.Transacciones;
import java.util.Date;

import com.Crediban.apirest.Tarjeta.Tarjeta;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transacciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;
    
    @Basic
    private String numeroTarjeta;
    private Date fechaTransaccion;
    private double monto;

    @ManyToOne
    private Tarjeta tarjeta;

    // Getters y Setters
}

