package ru.fllcker.urlshorter.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author github.com/fllcker
 */
public class SimpleHttpException extends ResponseStatusException {
    public SimpleHttpException(HttpStatusCode status, String message) {
        super(status, message);
    }
}
