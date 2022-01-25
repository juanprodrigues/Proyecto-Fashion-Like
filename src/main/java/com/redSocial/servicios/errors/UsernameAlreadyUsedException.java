package com.redSocial.servicios.errors;

public class UsernameAlreadyUsedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsernameAlreadyUsedException() {
        super(ErrorConstantes.MESSAGE_EMAIL_ALREADY_USED);
    }

    public UsernameAlreadyUsedException(String message) {
        super(message);
    }

}
