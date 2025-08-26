package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.PedidoItemRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.PedidoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.PedidoRespostaDto;
import br.futurodev.jmt.m2s09.entidades.ClienteEntity;
import br.futurodev.jmt.m2s09.entidades.PedidoEntity;
import br.futurodev.jmt.m2s09.entidades.PedidoItemEntity;
import br.futurodev.jmt.m2s09.entidades.ProdutoEntity;
import br.futurodev.jmt.m2s09.excecoes.customizadas.PedidoNaoEncontradoException;
import br.futurodev.jmt.m2s09.mapeadores.PedidoMapper;
import br.futurodev.jmt.m2s09.repositorios.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    @Override
    public List<PedidoRespostaDto> buscar() {
        List<PedidoEntity> entidades = repository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        );

        return entidades.stream().map(PedidoMapper::toDto).toList();
    }

    @Override
    public PedidoRespostaDto buscarPorId(Long id) {
        PedidoEntity entidade = buscarEntidadePorId(id);
        return PedidoMapper.toDto(entidade);
    }

    @Override
    public PedidoRespostaDto criar(PedidoRequisicaoDto dto) {
        PedidoEntity entidade = new PedidoEntity();
        PedidoMapper.toEntidade(entidade, dto);

        // Validação de cliente
        ClienteEntity cliente = clienteService.buscarEntidadePorId(dto.clienteId());
        entidade.setCliente(cliente);

        for (int i = 0; i < entidade.getItens().size(); i++) {
            // Variáveis auxiliares
            PedidoItemEntity item = entidade.getItens().get(i);
            PedidoItemRequisicaoDto itemDto = dto.itens().get(i);

            // Validação do produto
            ProdutoEntity produto = produtoService.buscarEntidadePorId(itemDto.produtoId());
            item.setProduto(produto);

            // Validação da quantidade
            if (item.getQuantidade() == null || item.getQuantidade() == 0) {
                item.setQuantidade(1);
            } else if (item.getQuantidade() < 0) {
                item.setQuantidade(item.getQuantidade() * -1);
            }

            // Validação do desconto
            if (item.getDesconto() == null || item.getDesconto().compareTo(BigDecimal.ZERO) < 0) {
                item.setDesconto(BigDecimal.ZERO);
            }

            item.setValorUnitario(produto.getPreco());

            // Calculando o total bruto do item
            BigDecimal totalBruto = item.getValorUnitario().multiply(
                    new BigDecimal(item.getQuantidade())
            );

            // Calculando o desconto
            BigDecimal valorDesconto = BigDecimal.ZERO;
            if (item.getDesconto().compareTo(BigDecimal.ZERO) > 0) {
                valorDesconto = totalBruto
                        .multiply(item.getDesconto())
                        .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
            }
            item.setDesconto(valorDesconto);

            // Calculando o total do item
            item.setTotal(
                    totalBruto.subtract(valorDesconto)
            );

            // Calculando os totalizadores do pedido
            entidade.setTotalItens(totalBruto.add(entidade.getTotalItens()));
            entidade.setTotalDesconto(valorDesconto.add(entidade.getTotalDesconto()));
            entidade.setTotal(item.getTotal().add(entidade.getTotal()));
        }

        repository.save(entidade);

        return PedidoMapper.toDto(entidade);
    }

    private PedidoEntity buscarEntidadePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new PedidoNaoEncontradoException(id));
    }

}
