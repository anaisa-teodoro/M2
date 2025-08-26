package br.futurodev.jmt.m2s09.repositorios;

import br.futurodev.jmt.m2s09.entidades.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
