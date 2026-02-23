package com.vini.controle_despesas.Despesa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_despesa")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class DespesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private int valor;

    @Column(name = "tipo")
    private DespesaTipo tipo;

    @Column(name = "prioridade")
    private DespesaPrioridade prioridade;

    @Column(name = "status")
    private DespesaStatus status;

    @Column(name = "dataVencimento")
    private LocalDate dataVencimento;

}
