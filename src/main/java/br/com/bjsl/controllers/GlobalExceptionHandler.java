package br.com.bjsl.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
  
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handle(MethodArgumentNotValidException exception) {
        return error(exception.getBindingResult().getFieldErrors()
                             .stream()
                             .map(FieldError::getDefaultMessage)
                             .collect(Collectors.toList()));
    }
  
    private Map error(Object message) {
      return Collections.singletonMap("error", message);
    }
}
