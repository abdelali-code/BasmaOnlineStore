package ma.youcode.basmastoreapi.exceptions;

public class ShoppingCartNotExistException extends RuntimeException {

    public ShoppingCartNotExistException(String message) {
        super(message);
    }
}
