package br.futurodev.jmt.m2s09.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 512)
    private String descricao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CategoriaEntity categoria;

    @Column(name = "valor_unitario", nullable = false, precision = 19, scale = 2)
    private BigDecimal preco = BigDecimal.ZERO;

}
