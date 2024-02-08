package com.Crediban.apirest.Tarjeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public Tarjeta crearTarjeta(Long idProducto, String nombreTitular) {
        // Generar el número de tarjeta (como se indica en el enunciado)
        String numeroTarjeta = generarNumeroTarjeta(idProducto);

        // Crear la nueva tarjeta
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setIdProducto(idProducto);
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setNombreTitular(nombreTitular);
        tarjeta.setFechaCreacion(new Date());
        tarjeta.setFechaVencimiento(calcularFechaVencimiento());
        tarjeta.setSaldo(0.0);
        tarjeta.setActivada(false);
        tarjeta.setBloqueada(false);

        // Guardar la tarjeta en la base de datos
        return tarjetaRepository.save(tarjeta);
    }

    private String generarNumeroTarjeta(Long idProducto) {
        // Lógica para generar el número de tarjeta según el enunciado
        return idProducto + "1234567890123456";
    }

    private Date calcularFechaVencimiento() {
        // Obtener la fecha actual
        Date fechaCreacion = new Date();

        // Crear un objeto Calendar e inicializarlo con la fecha de creación
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaCreacion);

        // Añadir 3 años a la fecha de creación
        calendar.add(Calendar.YEAR, 3);

        // Obtener la fecha de vencimiento actualizada
        return calendar.getTime();
    }

    // Método para activar una tarjeta
    public void activarTarjeta(String numeroTarjeta) {
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);
        if (optionalTarjeta.isPresent()) {
            Tarjeta tarjeta = optionalTarjeta.get();
            tarjeta.setActivada(true);
            tarjetaRepository.save(tarjeta);
        } else {
            throw new TarjetaNotFoundException("Tarjeta no encontrada");
        }
    }
    public void bloquearTarjeta(String numeroTarjeta) {
        Tarjeta tarjeta = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta)
                .orElseThrow(() -> new TarjetaNotFoundException("Tarjeta no encontrada"));

        // Lógica para bloquear la tarjeta
        tarjeta.setBloqueada(true);

        tarjetaRepository.save(tarjeta);
    }

    // Método para recargar saldo en una tarjeta
    public void recargarSaldo(String numeroTarjeta, double saldoRecarga) {
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);
        
        if (optionalTarjeta.isPresent()) {
            Tarjeta tarjeta = optionalTarjeta.get();
            double saldoActual = tarjeta.getSaldo();
            
            // Verificar si la recarga es un valor positivo
            if (saldoRecarga <= 0) {
                throw new IllegalArgumentException("El monto de recarga debe ser un valor positivo");
            }
            
            // Verificar si la tarjeta está bloqueada
            if (tarjeta.isBloqueada()) {
                throw new IllegalStateException("No se puede recargar saldo en una tarjeta bloqueada");
            }
            
            // Actualizar el saldo de la tarjeta
            tarjeta.setSaldo(saldoActual + saldoRecarga);
            tarjetaRepository.save(tarjeta);
        } else {
            throw new TarjetaNotFoundException("Tarjeta no encontrada");
        }
    }

    // Método para obtener información de la tarjeta por su número
    public Tarjeta obtenerInformacionTarjeta(String numeroTarjeta) {
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);
        if (optionalTarjeta.isPresent()) {
            return optionalTarjeta.get();
        } else {
            throw new TarjetaNotFoundException("Tarjeta no encontrada");
        }
    }

    public Tarjeta emitirNuevaTarjeta(Long idProducto, String nombreTitular) {
        // Generar número de tarjeta (ejemplo simple)
        String numeroTarjeta = generarNumeroTarjeta(idProducto);

        // Calcular fecha de vencimiento (3 años después de la fecha actual)
        Date fechaCreacion = new Date();
        Date fechaVencimiento = calcularFechaVencimiento(fechaCreacion);

        // Crear objeto Tarjeta con los datos proporcionados
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setIdProducto(idProducto);
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setNombreTitular(nombreTitular);
        tarjeta.setFechaCreacion(fechaCreacion);
        tarjeta.setFechaVencimiento(fechaVencimiento);
        tarjeta.setSaldo(0.0);
        tarjeta.setActivada(false);
        tarjeta.setBloqueada(false);

        // Guardar la nueva tarjeta en la base de datos
        return tarjetaRepository.save(tarjeta);
    }
    private Date calcularFechaVencimiento(Date fechaCreacion) {
        // Crear un objeto Calendar y configurarlo con la fecha de creación
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaCreacion);

        // Añadir tres años a la fecha de creación
        calendar.add(Calendar.YEAR, 3);

        // Obtener la fecha resultante y devolverla
        return calendar.getTime();
    }

}
