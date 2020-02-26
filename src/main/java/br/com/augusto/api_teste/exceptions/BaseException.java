package br.com.augusto.api_teste.exceptions;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.augusto.api_teste.model.ApiError;

@ControllerAdvice
public class BaseException extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(BaseException.class);

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		LOGGER.warn("Nova exception ...");

		ApiError apiError = new ApiError(status, "Missing Request", Arrays.asList(ex.getMessage()));

		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<Object> handlerCarNotFoundException(CarNotFoundException ex, WebRequest request) {
		
		LOGGER.warn("Nova exception ...");
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), Arrays.asList(ex.getMessage()));
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
