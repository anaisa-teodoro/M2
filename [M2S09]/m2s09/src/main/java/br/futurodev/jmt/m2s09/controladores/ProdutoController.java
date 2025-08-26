package br.futurodev.jmt.m2s09.controladores;

import br.futurodev.jmt.m2s09.dtos.ProdutoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ProdutoRespostaDto;
import br.futurodev.jmt.m2s09.servicos.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 - CREATED
    public ProdutoRespostaDto post(@RequestBody ProdutoRequisicaoDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<ProdutoRespostaDto> get() {
        return service.buscar();
    }

    @GetMapping("{id}")
    public ProdutoRespostaDto getPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("{id}")
    public ProdutoRespostaDto put(
            @PathVariable Long id,
            @RequestBody ProdutoRequisicaoDto dto
    ) {
        return service.alterar(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    private void delete(@PathVariable Long id) {
        service.excluir(id);
    }

}
