package br.futurodev.jmt.m2s09.repositorios;

import br.futurodev.jmt.m2s09.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
