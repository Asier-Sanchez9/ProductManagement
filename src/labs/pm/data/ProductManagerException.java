package labs.pm.data;

public class ProductManagerException extends Exception {
    public ProductManagerException(String message) {
        super(message);
    }

    public ProductManagerException() {
    }

    public ProductManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
