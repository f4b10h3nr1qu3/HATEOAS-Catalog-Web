package com.f4b10h3nr1qu3.catalog.controller.handler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = RepositoryRestController.class)
public class GenericExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Value("${custom.rest.response.enable.exception.original.details}")
	private Boolean enableOrignalExceptionDetais;

	@Value("${custom.rest.response.enable.exception.message.details}")
	private Boolean enableExceptionDetais;

	@ExceptionHandler(value = org.springframework.dao.DataIntegrityViolationException.class)
	// if you don't use Exception e in method you can remove it , live only Locale
	public ResponseEntity<CustomErrorMessage> handle(Exception e, Locale locale) {
		CustomErrorMessage customError = null;
		customError = createErrorResponse(e, "msg_constraint_violation", new Object[] {}, locale,
				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<CustomErrorMessage>(customError, new HttpHeaders(), customError.getStatus());
	}

	public CustomErrorMessage createErrorResponse(Exception e, String messageKey, Object[] paramsOfMessage,
			Locale locale, HttpStatus httpStatus) {
		CustomErrorMessage customError = new CustomErrorMessage();
		String reason = messageSource.getMessage(messageKey, paramsOfMessage, locale);
		customError.setStatus(httpStatus);
		customError.setReason(reason);
		if (enableExceptionDetais) {
			customError.setDetails(e.getMessage());
		}
		if (enableOrignalExceptionDetais) {
			customError.setOriginalException(e);
		}
		return customError;

	}

}
