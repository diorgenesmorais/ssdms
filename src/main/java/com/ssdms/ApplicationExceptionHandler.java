package com.ssdms;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.dms.useful.exception.handler.ResourcesExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResourcesExceptionHandler {

}
