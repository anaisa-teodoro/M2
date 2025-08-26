package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.CategoriaRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.CategoriaRespostaDto;
import br.futurodev.jmt.m2s09.entidades.CategoriaEntity;
import br.futurodev.jmt.m2s09.excecoes.customizadas.CategoriaNaoEncontradaException;
import br.futurodev.jmt.m2s09.excecoes.customizadas.NaoEncontradoException;
import br.futurodev.jmt.m2s09.mapeadores.CategoriaMapper;
import br.futurodev.jmt.m2s09.repositorios.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Override
    public List<CategoriaRespostaDto> buscar() {
        List<CategoriaEntity> entidades = repository.findAll(
                Sort.by(Sort.Direction.ASC, "nome")
        );

        return entidades.stream().map(CategoriaMapper::toDto).toList();
    }

    @Override
    public CategoriaRespostaDto buscarPorId(Long id) {
        CategoriaEntity entidade = buscarEntidadePorId(id);
        return CategoriaMapper.toDto(entidade);
    }

    @Override
    public CategoriaRespostaDto criar(CategoriaRequisicaoDto dto) {
        CategoriaEntity entidade = salvarEntidade(
                new CategoriaEntity(),
                dto
        );
        return CategoriaMapper.toDto(entidade);
    }

    @Override
    public CategoriaRespostaDto alterar(Long id, CategoriaRequisicaoDto dto) {
        CategoriaEntity entidade = salvarEntidade(
                buscarEntidadePorId(id),
                dto
        );
        return CategoriaMapper.toDto(entidade);
    }

    @Override
    public void excluir(Long id) {
        CategoriaEntity entidade = buscarEntidadePorId(id);
        repository.delete(entidade);
    }

    @Override
    public CategoriaEntity buscarEntidadePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    private CategoriaEntity salvarEntidade(CategoriaEntity entidade, CategoriaRequisicaoDto dto) {
        CategoriaMapper.toEntidade(entidade, dto);
        return repository.save(entidade);
    }

}
