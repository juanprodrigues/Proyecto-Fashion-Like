package com.redSocial.servicios.errors;

public class ValueNotPresent extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public ValueNotPresent() {
        super();
    }

    public ValueNotPresent(String message) {
        super(message);
    }

}
