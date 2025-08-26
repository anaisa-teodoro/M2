package br.futurodev.jmt.m2s09.repositorios;

import br.futurodev.jmt.m2s09.entidades.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
