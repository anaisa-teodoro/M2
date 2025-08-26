package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.ClienteRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ClienteRespostaDto;
import br.futurodev.jmt.m2s09.entidades.ClienteEntity;
import br.futurodev.jmt.m2s09.excecoes.customizadas.ClienteNaoEncontradoException;
import br.futurodev.jmt.m2s09.mapeadores.ClienteMapper;
import br.futurodev.jmt.m2s09.repositorios.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<ClienteRespostaDto> buscar() {
        List<ClienteEntity> entidades = repository.findAll(
                Sort.by(Sort.Direction.ASC, "nome")
        );

        return entidades.stream().map(ClienteMapper::toDto).toList();
    }

    @Override
    public ClienteRespostaDto buscarPorId(Long id) {
        ClienteEntity entidade = buscarEntidadePorId(id);
        return ClienteMapper.toDto(entidade);
    }

    @Override
    public ClienteRespostaDto criar(ClienteRequisicaoDto dto) {
        ClienteEntity entidade = salvarEntidade(
                new ClienteEntity(),
                dto
        );
        return ClienteMapper.toDto(entidade);
    }

    @Override
    public ClienteRespostaDto alterar(Long id, ClienteRequisicaoDto dto) {
        ClienteEntity entidade = salvarEntidade(
                buscarEntidadePorId(id),
                dto
        );
        return ClienteMapper.toDto(entidade);
    }

    @Override
    public void excluir(Long id) {
        ClienteEntity entidade = buscarEntidadePorId(id);
        repository.delete(entidade);
    }

    @Override
    public void ativar(Long id) {
        ClienteEntity entidade = buscarEntidadePorId(id);

        if (entidade.getAtivo()) {
            throw new RuntimeException("Cliente já ativo!");
        }

        entidade.setAtivo(true);
        repository.save(entidade);
    }

    @Override
    public void desativar(Long id) {
        ClienteEntity entidade = buscarEntidadePorId(id);

        if (!entidade.getAtivo()) {
            throw new RuntimeException("Cliente já desativado!");
        }

        entidade.setAtivo(false);
        repository.save(entidade);
    }

    @Override
    public ClienteEntity buscarEntidadePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    private ClienteEntity salvarEntidade(ClienteEntity entidade, ClienteRequisicaoDto dto) {
        ClienteMapper.toEntidade(entidade, dto);
        return repository.save(entidade);
    }

}
