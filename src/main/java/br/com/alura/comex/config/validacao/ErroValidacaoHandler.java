package br.com.alura.comex.config.validacao;

import br.com.alura.comex.exception.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacaoDTO> handle(MethodArgumentNotValidException exception){
        List<ErroValidacaoDTO> erros = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            erros.add(new ErroValidacaoDTO(e.getField(),mensagem));
        });

        return erros;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public String handle(ObjetoNaoEncontradoException exception){
        return exception.getMessage();
    }


}
