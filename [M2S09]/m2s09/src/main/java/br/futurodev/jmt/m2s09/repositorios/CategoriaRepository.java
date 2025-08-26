package br.futurodev.jmt.m2s09.repositorios;

import br.futurodev.jmt.m2s09.entidades.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
