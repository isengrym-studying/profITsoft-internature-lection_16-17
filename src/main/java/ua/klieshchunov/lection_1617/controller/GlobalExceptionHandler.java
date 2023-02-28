package ua.klieshchunov.lection_1617.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.klieshchunov.lection_1617.exception.FileUploadException;
import ua.klieshchunov.lection_1617.exception.PepNotFoundException;
import ua.klieshchunov.lection_1617.exception.ToDtoConversionException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PepNotFoundException.class)
    protected ResponseEntity<Object> handleBookAlreadyExistsException(PepNotFoundException e) {
        log.warn("PepNotFoundException thrown: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ToDtoConversionException.class)
    protected ResponseEntity<Object> handleToDtoConversionException(ToDtoConversionException e) {
        log.warn("ToDtoConversionException thrown: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileUploadException.class)
    protected ResponseEntity<Object> handleFileUploadException(FileUploadException e) {
        log.warn("FileUploadException thrown: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
