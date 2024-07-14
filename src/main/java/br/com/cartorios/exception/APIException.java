package br.com.cartorios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class APIException extends RuntimeException{
    public APIException(String message) {
        super(message);
    }
}
