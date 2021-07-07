package br.com.qm.api.pecas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.qm.api.pecas.dto.ResponseDTO;

// Essa anotação serve para dizer que ele está olhando pra exceptions jogadas
// no controller.
@ControllerAdvice
public class GlobalExceptionHandler {

	// Aqui nós dizemos qual status http deverá ser retornado.
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	// Aqui específicamos qual exception tratar
    @ExceptionHandler({ErroDeNegocioException.class})
    public @ResponseBody ResponseDTO handleBusinessErrors(Exception e) {
        return new ResponseDTO(e.getMessage());
    }
	
}
