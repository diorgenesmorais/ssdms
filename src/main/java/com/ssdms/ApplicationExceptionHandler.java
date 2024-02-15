package com.ssdms;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dms.useful.exception.handler.ResourcesExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResourcesExceptionHandler {

}
