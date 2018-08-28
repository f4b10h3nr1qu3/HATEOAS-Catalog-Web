package com.f4b10h3nr1qu3.catalog.controller.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such product") // 404
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
