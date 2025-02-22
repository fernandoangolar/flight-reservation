package ao.com.angotech.exception.handler;

import ao.com.angotech.dto.error.ErrorResponseDto;
import ao.com.angotech.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException n) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setMessage(n.getMessage());
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(FlightAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(FlightAlreadyExistsException n) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setMessage(n.getMessage());
        errorResponse.setHttpStatus(HttpStatus.CONFLICT);
        errorResponse.setStatusCode(HttpStatus.CONFLICT.value());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(InvalidFlightRouteException.class)
    public ResponseEntity<ErrorResponseDto> invalidRouteException(InvalidFlightRouteException n) {

        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setMessage(n.getMessage());
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }

    @ExceptionHandler(InvalidSeatAllocationException.class)
    public ResponseEntity<ErrorResponseDto> invalidSeatException(InvalidSeatAllocationException n) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(n.getMessage());
        errorResponseDto.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDto);
    }


    @ExceptionHandler(InvalidFlightScheduleException.class)
    public ResponseEntity<ErrorResponseDto> invalidSeatException(InvalidFlightScheduleException n) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(n.getMessage());
        errorResponseDto.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(MethodArgumentNotValidException m) {

        Map<String, String> messages = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(Arrays.toString(messages.entrySet().toArray()));
        errorResponseDto.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);


//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
//                .message(Arrays.toString(messages.entrySet().toArray()))
//                .httpStatus(HttpStatus.BAD_REQUEST)
//                .statusCode(HttpStatus.BAD_REQUEST.value())
//                .build());
    }

}
