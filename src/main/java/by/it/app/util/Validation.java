package by.it.app.util;

/**
 * The type Validation.
 */
public class Validation {

    /**
     * Validate.
     *
     * @param expression   the expression
     * @param errorMessage the error message
     */
    public static void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
