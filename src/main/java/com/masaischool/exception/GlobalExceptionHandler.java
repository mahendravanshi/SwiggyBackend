package com.masaischool.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



	@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDetails> customerNotFound(CustomerNotFoundException nhf, WebRequest wr) {
        log.error("Customer not found exception", nhf);
        
        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
    

    @ExceptionHandler(DeliveryPartenerNoFoundException.class)
    public ResponseEntity<ErrorDetails> dpNotFound(DeliveryPartenerNoFoundException nhf, WebRequest wr) {
        log.error("Delivery partner not found exception", nhf);

        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidStateException.class)
    public ResponseEntity<ErrorDetails> invalidStateFound(InvalidStateException nhf, WebRequest wr) {
        log.error("Invalid state exception", nhf);

        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoItemFoundException.class)
    public ResponseEntity<ErrorDetails> noItemFound(NoItemFoundException nhf, WebRequest wr) {
        log.error("No item found exception", nhf);

        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDetails> orderNotFound(OrderNotFoundException nhf, WebRequest wr) {
        log.error("Order not found exception", nhf);

        
        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();
        
        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderStatusNotFoundException.class)
    public ResponseEntity<ErrorDetails> orderStatusNotFound(OrderStatusNotFoundException nhf, WebRequest wr) {
        log.error("Order status not found exception", nhf);

        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderUpdateException.class)
    public ResponseEntity<ErrorDetails> orderupdateException(OrderUpdateException nhf, WebRequest wr) {
        log.error("Order update exception", nhf);

        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorDetails> restaurantNotFoundException(RestaurantNotFoundException nhf, WebRequest wr) {
        log.error("Restaurant not found exception", nhf);

        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFound(NoHandlerFoundException nhf, WebRequest wr) {
        log.error("No handler found exception", nhf);
               
        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> exceptionFound(Exception nhf, WebRequest wr) {
        log.error("Exception found exception", nhf);
               
        ErrorDetails ed = ErrorDetails.builder().message(nhf.getMessage()).timeStamp(LocalDateTime.now())
                .uri(wr.getDescription(false)).build();

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> exceptionFound(MethodArgumentNotValidException nhf, WebRequest wr) {
        log.error("MethodArgumentNotValidException exception", nhf);
               
        

         List<ObjectError> allErrors = nhf.getAllErrors();
         List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);
        return new ResponseEntity<>(errorsToStringList, HttpStatus.BAD_REQUEST);
    }
    
    
    
    
    
    
    
    
    
}  
    