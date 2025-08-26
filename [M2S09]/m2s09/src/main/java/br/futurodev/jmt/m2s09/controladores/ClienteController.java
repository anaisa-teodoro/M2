package br.futurodev.jmt.m2s09.controladores;

import br.futurodev.jmt.m2s09.dtos.ClienteRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ClienteRespostaDto;
import br.futurodev.jmt.m2s09.servicos.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 - CREATED
    public ClienteRespostaDto post(@RequestBody ClienteRequisicaoDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<ClienteRespostaDto> get() {
        return service.buscar();
    }

    @GetMapping("{id}")
    public ClienteRespostaDto getPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("{id}")
    public ClienteRespostaDto put(
            @PathVariable Long id,
            @RequestBody ClienteRequisicaoDto dto
    ) {
        return service.alterar(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    private void delete(@PathVariable Long id) {
        service.excluir(id);
    }

    @PatchMapping("{id}/ativar")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    private void ativar(@PathVariable Long id) {
        service.ativar(id);
    }

    @PatchMapping("{id}/desativar")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    private void desativar(@PathVariable Long id) {
        service.desativar(id);
    }

}
