package com.vini.controle_despesas.domain.parcelamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoJurosTipo;
import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="tb_parcelamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParcelamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "status_parcelamento")
    private ParcelamentoStatus parcelamentoStatus;

    @Column (name = "valor_original")
    private BigDecimal valorOriginal;

    @Column (name = "valor_parcela")
    private BigDecimal valorParcela;

    @Column (name = "valor_parcelado")
    private BigDecimal valorParcelado;

    @Column(name = "quantidade_parcelas")
    private Integer quantidadeParcelas;

    @Column (name = "parcelas_pagas")
    private Integer parcelasPagas;

    @Column (name = "data_inicio")
    private LocalDate dataInicio;

    @Column (name = "tipo_juros")
    private ParcelamentoJurosTipo tipoJuros;

    @JsonIgnore
    @OneToOne(mappedBy = "parcelamento")
    private DespesaModel despesa;

}
