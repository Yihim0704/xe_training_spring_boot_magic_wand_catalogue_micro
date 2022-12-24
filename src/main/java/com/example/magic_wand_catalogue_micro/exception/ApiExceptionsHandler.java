package com.example.magic_wand_catalogue_micro.exception;

import brave.Span;
import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionsHandler {

    @Autowired
    private Tracer tracer;

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionsHandler.class);

    public String generateTraceId() {
        String traceId = null;
        Span span = tracer.currentSpan();
        if (span != null) {
            traceId = span.context().traceIdString();
        }
        return traceId;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> message = new HashMap<>();
        Map<String, String> errorMap = new HashMap<>();
        String methodArgumentNotValidExceptionTraceId = generateTraceId();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        message.put("code", HttpStatus.BAD_REQUEST.toString());
        message.put("message", errorMap);
        ExceptionFormat exceptionFormat = new ExceptionFormat("NOK", 1, LocalDateTime.now(), methodArgumentNotValidExceptionTraceId, message);
        logger.info("MethodArgumentNotValidExceptionTraceId: {}", methodArgumentNotValidExceptionTraceId);
        logger.info(String.valueOf(exceptionFormat.toFormat()));
        return exceptionFormat.toFormat();
    }

    @ExceptionHandler(MagicWandCatalogueExistException.class)
    public Map<String, Object> handleWizardInfoExistException(MagicWandCatalogueExistException ex) {
        Map<String, Object> message = new HashMap<>();
        String magicWandCatalogueExistExistException = generateTraceId();
        message.put("code", HttpStatus.CONFLICT.toString());
        message.put("message", ex.getLocalizedMessage());
        ExceptionFormat exceptionFormat = new ExceptionFormat("NOK", 1, LocalDateTime.now(), magicWandCatalogueExistExistException, message);
        logger.info("MagicWandCatalogueExistExceptionTraceId: {}", magicWandCatalogueExistExistException);
        logger.info(String.valueOf(exceptionFormat.toFormat()));
        return exceptionFormat.toFormat();
    }

    @ExceptionHandler(NoMagicWandCatalogueFoundException.class)
    public Map<String, Object> handleNoWizardInfoFoundException(NoMagicWandCatalogueFoundException ex) {
        Map<String, Object> message = new HashMap<>();
        String noMagicWandCatalogueFoundExceptionTraceId = generateTraceId();
        message.put("code", HttpStatus.NO_CONTENT.toString());
        message.put("message", ex.getLocalizedMessage());
        ExceptionFormat exceptionFormat = new ExceptionFormat("NOK", 1, LocalDateTime.now(), noMagicWandCatalogueFoundExceptionTraceId, message);
        logger.info("NoMagicWandCatalogueFoundExceptionTraceId: {}", noMagicWandCatalogueFoundExceptionTraceId);
        logger.info(String.valueOf(exceptionFormat.toFormat()));
        return exceptionFormat.toFormat();
    }

    @ExceptionHandler(MagicWandCatalogueIdNotFoundException.class)
    public Map<String, Object> handleWizardIdNotFoundException(MagicWandCatalogueIdNotFoundException ex) {
        Map<String, Object> message = new HashMap<>();
        String magicWandCatalogueIdNotFoundExceptionTraceId = generateTraceId();
        message.put("code", HttpStatus.NOT_FOUND.toString());
        message.put("message", ex.getLocalizedMessage());
        ExceptionFormat exceptionFormat = new ExceptionFormat("NOK", 1, LocalDateTime.now(), magicWandCatalogueIdNotFoundExceptionTraceId, message);
        logger.info("MagicWandCatalogueIdNotFoundExceptionTraceId: {}", magicWandCatalogueIdNotFoundExceptionTraceId);
        logger.info(String.valueOf(exceptionFormat.toFormat()));
        return exceptionFormat.toFormat();
    }
}
