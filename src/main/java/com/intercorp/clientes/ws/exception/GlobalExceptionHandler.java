package com.intercorp.clientes.ws.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.intercorp.clientes.core.base.exceptions.BadRequestException;
import com.intercorp.clientes.core.base.exceptions.CustomBadRequestException;
import com.intercorp.clientes.core.base.exceptions.EmptyResultException;
import com.intercorp.clientes.core.base.exceptions.dto.ErrorDetails;
import com.intercorp.clientes.core.base.exceptions.dto.ErrorDetailsFields;
import com.intercorp.clientes.core.base.utils.Constantes;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		ErrorDetailsFields errorDetails = new ErrorDetailsFields(400, Constantes.PARAMETROS_INVALIDOS);
		for (org.springframework.validation.FieldError fieldError : fieldErrors) {
			errorDetails.agregarCampoError(fieldError.getDefaultMessage(), fieldError.getField());
		}
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> BadRequestException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultException.class)
	public ResponseEntity<?> emptyResultException(EmptyResultException ex, WebRequest request) {
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> CustomParseException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getCause().getCause().getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> NumberFormatException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomBadRequestException.class)
	public ResponseEntity<?> CustomBadRequestException(CustomBadRequestException ex) {
		ErrorDetailsFields errorDetails = new ErrorDetailsFields(400, Constantes.PARAMETROS_INVALIDOS);
		errorDetails.setCampos(ex.getCamposErroneos());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}