package com.Crediban.apirest.Transacciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @PostMapping("/realizarCompra")
    public Transacciones realizarCompra(@RequestParam String numeroTarjeta, @RequestParam double monto) {
        return transaccionesService.realizarCompra(numeroTarjeta, monto);
    }

    @GetMapping("/{id}")
    public Transacciones obtenerTransaccionPorId(@PathVariable int id) {
        return transaccionesService.obtenerTransaccionPorId(id);
    }

    @DeleteMapping("/anular/{id}")
    public void anularTransaccion(@PathVariable int id) {
        transaccionesService.anularTransaccion(id);
    }
}

