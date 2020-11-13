package hu.uni.eku.tzs.service.exceptions;

public class InsufficientAgeToBuyException extends RuntimeException {
    public InsufficientAgeToBuyException(String errorMessage) {
        super(errorMessage);
    }
}
