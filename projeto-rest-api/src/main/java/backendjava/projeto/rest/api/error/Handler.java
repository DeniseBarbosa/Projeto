package backendjava.projeto.rest.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(TratamentoDeErro.class)
    public ResponseEntity<?> handleNotFoundException(TratamentoDeErro ex){
        MensagemErro error = new MensagemErro("Not Found", HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
