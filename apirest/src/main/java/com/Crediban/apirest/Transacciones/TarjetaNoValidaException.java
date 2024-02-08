package com.Crediban.apirest.Transacciones;

public class TarjetaNoValidaException extends RuntimeException {

    public TarjetaNoValidaException() {
        super();
    }

    public TarjetaNoValidaException(String message) {
        super(message);
    }

    public TarjetaNoValidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public TarjetaNoValidaException(Throwable cause) {
        super(cause);
    }
}
