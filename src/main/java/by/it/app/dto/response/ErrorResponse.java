package by.it.app.dto.response;

import org.springframework.http.HttpStatus;


/**
 * The type Error response.
 */
public class ErrorResponse {

    private HttpStatus httpStatus;

    private String message;

    /**
     * Instantiates a new Error response.
     *
     * @param httpStatus the http status
     * @param message    the message
     */
    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * Gets http status.
     *
     * @return the http status
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Sets http status.
     *
     * @param httpStatus the http status
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
