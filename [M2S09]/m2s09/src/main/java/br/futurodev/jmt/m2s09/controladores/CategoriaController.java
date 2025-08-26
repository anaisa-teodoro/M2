package br.futurodev.jmt.m2s09.controladores;

import br.futurodev.jmt.m2s09.dtos.CategoriaRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.CategoriaRespostaDto;
import br.futurodev.jmt.m2s09.servicos.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 - CREATED
    public CategoriaRespostaDto post(@RequestBody CategoriaRequisicaoDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<CategoriaRespostaDto> get() {
        return service.buscar();
    }

    @GetMapping("{id}")
    public CategoriaRespostaDto getPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("{id}")
    public CategoriaRespostaDto put(
            @PathVariable Long id,
            @RequestBody CategoriaRequisicaoDto dto
    ) {
        return service.alterar(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    private void delete(@PathVariable Long id) {
        service.excluir(id);
    }

}
