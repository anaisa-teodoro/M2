package br.futurodev.jmt.m2s09.controladores;

import br.futurodev.jmt.m2s09.dtos.PedidoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.PedidoRespostaDto;
import br.futurodev.jmt.m2s09.servicos.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 - CREATED
    public PedidoRespostaDto post(@RequestBody PedidoRequisicaoDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<PedidoRespostaDto> get() {
        return service.buscar();
    }

    @GetMapping("{id}")
    public PedidoRespostaDto getPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

}
