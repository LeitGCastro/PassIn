package rocketseat.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeAlreadyExistsException;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistException;
import rocketseat.com.passin.domain.event.exceptions.EventFullException;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.passin.dto.general.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventFull(EventNotFoundException exception){
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }
    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    public ResponseEntity handleAttendeeAlreadyExist(EventNotFoundException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @ExceptionHandler(CheckInAlreadyExistException.class)
    public ResponseEntity handleCheckInAlreadyExist(EventNotFoundException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
