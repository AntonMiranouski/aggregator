package by.it.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Padobny element nia znojdzieny")
public class NotFoundException extends RuntimeException {
}
