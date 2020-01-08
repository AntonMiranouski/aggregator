package by.it.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Element z takim najmieńniem ŭžo isnuje")
public class NonUniqueException extends RuntimeException {
}
