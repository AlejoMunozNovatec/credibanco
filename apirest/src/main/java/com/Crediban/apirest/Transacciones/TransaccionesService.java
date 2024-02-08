package com.Crediban.apirest.Transacciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Crediban.apirest.Tarjeta.Tarjeta;
import com.Crediban.apirest.Tarjeta.TarjetaRepository;
import com.Crediban.apirest.Tarjeta.TarjetaService;

import java.util.Date;

@Service
public class TransaccionesService {

    @Autowired
    private TransaccionesRepository transaccionRepository;

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired // Asegúrate de tener esta anotación
    private TarjetaRepository tarjetaRepository;

    public Transacciones realizarCompra(String numeroTarjeta, double monto) {
        Tarjeta tarjeta = tarjetaService.obtenerInformacionTarjeta(numeroTarjeta);
        if (tarjeta.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente en la tarjeta");
        }

        if (!tarjeta.isActivada() || tarjeta.isBloqueada()) {
            throw new TarjetaNoValidaException("La tarjeta no está activada o está bloqueada");
        }

        Transacciones transaccion = new Transacciones();
        transaccion.setNumeroTarjeta(numeroTarjeta);
        transaccion.setMonto(monto);
        transaccion.setFechaTransaccion(new Date());
        transaccionRepository.save(transaccion);

        double nuevoSaldo = tarjeta.getSaldo() - monto;
        tarjeta.setSaldo(nuevoSaldo);
        tarjetaRepository.save(tarjeta);

        return transaccion;
    }

    // Método para obtener una transacción por su ID
    public Transacciones obtenerTransaccionPorId(int id) {
        return transaccionRepository.findById(id)
                .orElseThrow(() -> new TransaccionNotFoundException("Transacción no encontrada"));
    }

    // Método para anular una transacción
    public void anularTransaccion(int idTransaccion) {
        Transacciones transaccion = obtenerTransaccionPorId(idTransaccion);
        tarjetaService.recargarSaldo(transaccion.getNumeroTarjeta(), transaccion.getMonto());
        transaccionRepository.delete(transaccion);
    }
}
