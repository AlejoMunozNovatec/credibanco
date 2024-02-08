package com.Crediban.apirest.Transacciones;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super();
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }

    public SaldoInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaldoInsuficienteException(Throwable cause) {
        super(cause);
    }
}
