package br.com.banco.controllers;

import br.com.banco.exceptions.NullFilterException;
import br.com.banco.exceptions.ObjectNotFoundException;
import br.com.banco.exceptions.StandardError;
import br.com.banco.utils.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<StandardError>> beanValidationException(MethodArgumentNotValidException e){
            List<StandardError> listStandardError = e.getAllErrors().stream().map(
                    objectError -> convertObjectErrorToStandardError(objectError)).collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(listStandardError);
        }

        private StandardError convertObjectErrorToStandardError(ObjectError objectError){
            return new StandardError(objectError.getDefaultMessage(),
                    DateUtils.convertSystemTimeMillisToString(System.currentTimeMillis()),
                    HttpStatus.NOT_ACCEPTABLE.value());
        }

        @ExceptionHandler(ObjectNotFoundException.class)
        public ResponseEntity<StandardError> notFound(ObjectNotFoundException e){
            StandardError standardError = new StandardError(e.getMessage(),
                                                           DateUtils.convertSystemTimeMillisToString(System.currentTimeMillis()),
                                                           HttpStatus.NOT_FOUND.value());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
        }

    @ExceptionHandler(NullFilterException.class)
    public ResponseEntity<StandardError> nullFilter(NullFilterException e){
        StandardError standardError = new StandardError(e.getMessage(),
                DateUtils.convertSystemTimeMillisToString(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}
