package com.masai.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(BookNotFoundException bnf, WebRequest wr) {

		MyErrorDetails med = new MyErrorDetails(LocalDate.now(), bnf.getMessage(), wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerfound(NoHandlerFoundException nhf, WebRequest wr) {
		
		System.out.println("inside uri exception");
		
		MyErrorDetails mer = new MyErrorDetails(LocalDate.now(), nhf.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception exp, WebRequest wr) {

		MyErrorDetails med = new MyErrorDetails(LocalDate.now(), exp.getMessage(), wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationExceptionHandler(MethodArgumentNotValidException mev){
		
		MyErrorDetails mew = new MyErrorDetails(LocalDate.now(), "validation error", mev.getBindingResult().
																		getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(mew,HttpStatus.BAD_REQUEST);
		
	}

}
