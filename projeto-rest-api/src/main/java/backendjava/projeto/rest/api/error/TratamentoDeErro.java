package backendjava.projeto.rest.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TratamentoDeErro extends RuntimeException {
    public TratamentoDeErro(String mensagem){
        super(mensagem);
    }
}
