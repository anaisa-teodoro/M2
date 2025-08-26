package br.futurodev.jmt.m2s09.excecoes;

import br.futurodev.jmt.m2s09.dtos.ErroRespostaDto;
import br.futurodev.jmt.m2s09.excecoes.customizadas.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDto> handler(Exception e) {
        ErroRespostaDto erro = ErroRespostaDto.builder()
                .codigo("500")
                .mensagem(e.getMessage())
                .classe(e.getClass().getSimpleName())
                .build();

        // Status 500 (internal server error)
        return ResponseEntity.internalServerError().body(erro);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErroRespostaDto> handler(NoSuchElementException e) {
        return notFound(e);
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErroRespostaDto> handler(NaoEncontradoException e) {
        return notFound(e);
    }

    private ResponseEntity<ErroRespostaDto> notFound(Exception e) {
        ErroRespostaDto erro = ErroRespostaDto.builder()
                .codigo("404")
                .mensagem(e.getMessage())
                .classe(e.getClass().getSimpleName())
                .build();

        // Status 404 (Not found)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
