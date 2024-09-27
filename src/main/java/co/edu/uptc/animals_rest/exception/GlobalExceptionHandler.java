package co.edu.uptc.animals_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(InvalidRangeException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRangeException(InvalidRangeException ex) {
    
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());       
    
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }    

    @ExceptionHandler(CategoryNumberException.class)
    public ResponseEntity<Map<String, Object>> handleInvalideLengthException(CategoryNumberException ex){
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", ex.getMessage());
        response.put("timestamp", ex.getTimestamp());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
}
