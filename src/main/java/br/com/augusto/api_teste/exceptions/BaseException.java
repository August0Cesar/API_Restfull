package br.com.augusto.api_teste.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BaseException extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(BaseException.class);

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Exception encontrado.");
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
}
