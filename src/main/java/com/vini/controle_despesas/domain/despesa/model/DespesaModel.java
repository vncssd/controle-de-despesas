package com.vini.controle_despesas.domain.despesa.model;

import com.vini.controle_despesas.domain.despesa.enums.DespesaPrioridade;
import com.vini.controle_despesas.domain.despesa.enums.DespesaStatus;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
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

    private String descricao;

    private int valor;

    @Column(name = "tipo")
    private DespesaTipo tipo;

    @Column(name = "prioridade")
    private DespesaPrioridade prioridade;

    @Column(name = "status")
    private DespesaStatus status;

    @Column(name = "dataVencimento")
    private LocalDate dataVencimento;

    private ParcelamentoModel parcelamento;

}
