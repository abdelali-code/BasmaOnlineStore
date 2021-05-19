package ma.youcode.basmastoreapi.exceptions;

public class ProductOrderNotExistException extends RuntimeException {

    public ProductOrderNotExistException(String message) {
        super(message);
    }
}
