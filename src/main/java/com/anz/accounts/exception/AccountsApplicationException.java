package com.anz.accounts.exception;

public class AccountsApplicationException extends RuntimeException {

    private static final long serialVersionUID = 6541692676485965597L;

    /**
     * Constructs a new runtime exception with null as its
     * detail message.
     */
    public AccountsApplicationException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message.
     * @param  cause   the cause.

     */
    public AccountsApplicationException(final String message,
            final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     *
     * @param   message   the detail message.
     */
    public AccountsApplicationException(final String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified cause and null
     * as its detail message.
     *
     * @param  cause the cause.
     */
    public AccountsApplicationException(final Throwable cause) {
        super(cause);
    }
}
