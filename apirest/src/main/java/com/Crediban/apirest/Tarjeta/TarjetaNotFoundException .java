package com.Crediban.apirest.Tarjeta;

 class TarjetaNotFoundException extends RuntimeException {

    public TarjetaNotFoundException() {
        super();
    }

    public TarjetaNotFoundException(String message) {
        super(message);
    }

    public TarjetaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TarjetaNotFoundException(Throwable cause) {
        super(cause);
    }
}

