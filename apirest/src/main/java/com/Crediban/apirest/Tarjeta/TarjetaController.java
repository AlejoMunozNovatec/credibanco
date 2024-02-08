package com.Crediban.apirest.Tarjeta;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;
    @Autowired
    private TarjetaRepository tarjetaRepository;

    @PostMapping("/emitir")
    public Tarjeta emitirNuevaTarjeta(@RequestBody Tarjeta tarjetaRequest) {
        long idProducto = (int) tarjetaRequest.getIdProducto();
        String nombreTitular = tarjetaRequest.getNombreTitular();
        
        return tarjetaService.emitirNuevaTarjeta(idProducto, nombreTitular);
    }
    
    @DeleteMapping("/tarjetas/{numeroTarjeta}")
    public void bloquearTarjeta(@PathVariable String numeroTarjeta) {
        tarjetaService.bloquearTarjeta(numeroTarjeta);
    }

    @PostMapping("/activar/{numeroTarjeta}")
    public void activarTarjeta(@PathVariable String numeroTarjeta) {
        tarjetaService.activarTarjeta(numeroTarjeta);
    }

    @PostMapping("/recargar/{numeroTarjeta}")
    public void recargarSaldo(String numeroTarjeta, double saldoRecarga) {
        Optional<Tarjeta> optionalTarjeta = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);
        if (optionalTarjeta.isPresent()) {
            Tarjeta tarjeta = optionalTarjeta.get();
            double saldoActual = tarjeta.getSaldo();
            tarjeta.setSaldo(saldoActual + saldoRecarga);
            tarjetaRepository.save(tarjeta);
        } else {
            throw new TarjetaNotFoundException("Tarjeta no encontrada");
        }
    }

    @GetMapping("/{numeroTarjeta}")
    public Tarjeta obtenerInformacionTarjeta(@PathVariable String numeroTarjeta) {
        return tarjetaService.obtenerInformacionTarjeta(numeroTarjeta);
    }
}

