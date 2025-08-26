package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.ProdutoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ProdutoRespostaDto;
import br.futurodev.jmt.m2s09.entidades.CategoriaEntity;
import br.futurodev.jmt.m2s09.entidades.ProdutoEntity;
import br.futurodev.jmt.m2s09.excecoes.customizadas.NaoEncontradoException;
import br.futurodev.jmt.m2s09.excecoes.customizadas.ProdutoNaoEncontradoException;
import br.futurodev.jmt.m2s09.mapeadores.ProdutoMapper;
import br.futurodev.jmt.m2s09.repositorios.CategoriaRepository;
import br.futurodev.jmt.m2s09.repositorios.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaService categoriaService;

    @Override
    public List<ProdutoRespostaDto> buscar() {
        List<ProdutoEntity> entidades = repository.findAll(
                Sort.by(Sort.Direction.ASC, "nome")
        );

        return entidades.stream().map(ProdutoMapper::toDto).toList();
    }

    @Override
    public ProdutoRespostaDto buscarPorId(Long id) {
        ProdutoEntity entidade = buscarEntidadePorId(id);
        return ProdutoMapper.toDto(entidade);
    }

    @Override
    public ProdutoRespostaDto criar(ProdutoRequisicaoDto dto) {
        ProdutoEntity entidade = salvarEntidade(
                new ProdutoEntity(),
                dto
        );
        return ProdutoMapper.toDto(entidade);
    }

    @Override
    public ProdutoRespostaDto alterar(Long id, ProdutoRequisicaoDto dto) {
        ProdutoEntity entidade = salvarEntidade(
                buscarEntidadePorId(id),
                dto
        );
        return ProdutoMapper.toDto(entidade);
    }

    @Override
    public void excluir(Long id) {
        ProdutoEntity entidade = buscarEntidadePorId(id);
        repository.delete(entidade);
    }

    public ProdutoEntity buscarEntidadePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    private ProdutoEntity salvarEntidade(ProdutoEntity entidade, ProdutoRequisicaoDto dto) {
        ProdutoMapper.toEntidade(entidade, dto);

        CategoriaEntity categoria = categoriaService.buscarEntidadePorId(
                dto.categoriaId()
        );
        entidade.setCategoria(categoria);

        return repository.save(entidade);
    }

}
