package hu.uni.eku.tzs.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<String> handleGuestNotFound(final GuestNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guest not found");
    }

    @ExceptionHandler(InsufficientAgeToBuyException.class)
    public ResponseEntity<String> handleInsufficientAge(final InsufficientAgeToBuyException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleUnknownProduct(final ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<String> handleReservationNotFound(final ReservationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
    }

    @ExceptionHandler(NoFreeRoomException.class)
    public ResponseEntity<String> handleNoFreeRoom(final NoFreeRoomException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No free room available for given time");
    }
}
