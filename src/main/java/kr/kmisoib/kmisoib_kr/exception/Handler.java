package kr.kmisoib.kmisoib_kr.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(SymbolException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(SymbolException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleDataException() {
        return ResponseEntity.badRequest().body("Неверный формат данных");
    }

    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleLengthException() {
        return ResponseEntity.badRequest().body("Неверная длина сообщения или ключа");
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexOutOfBoundsException() {
        return ResponseEntity.badRequest().body("Неверная длина сообщения или ключа");
    }
}
