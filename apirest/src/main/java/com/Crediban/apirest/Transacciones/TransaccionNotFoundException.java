package com.Crediban.apirest.Transacciones;

public class TransaccionNotFoundException extends RuntimeException {

    public TransaccionNotFoundException() {
        super();
    }

    public TransaccionNotFoundException(String message) {
        super(message);
    }

    public TransaccionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransaccionNotFoundException(Throwable cause) {
        super(cause);
    }
}

