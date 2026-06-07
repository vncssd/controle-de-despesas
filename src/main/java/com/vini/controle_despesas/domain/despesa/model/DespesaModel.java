package com.vini.controle_despesas.domain.despesa.model;

import com.vini.controle_despesas.domain.despesa.enums.DespesaPrioridade;
import com.vini.controle_despesas.domain.despesa.enums.DespesaStatus;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_despesa")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class DespesaModel {

    @PrePersist
    public void prePersist(){
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @Column (name="valor_original")
    private BigDecimal valorOriginal;

    @Nullable
    @Column (name="valor_total")
    private BigDecimal valorTotal;

    @Column(name = "tipo")
    private DespesaTipo tipo;

    @Column(name = "prioridade")
    private DespesaPrioridade prioridade;

    @Column(name = "status")
    private DespesaStatus status;

    @Nullable
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Nullable
    @OneToOne
    @JoinColumn(name = "parcelamento_id")
    private ParcelamentoModel parcelamento;

}
