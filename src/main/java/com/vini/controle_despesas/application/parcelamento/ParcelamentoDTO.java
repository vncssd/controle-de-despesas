package com.vini.controle_despesas.application.parcelamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoJurosTipo;
import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelamentoDTO {

    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private ParcelamentoStatus parcelamentoStatus;

    @Schema(hidden = true)
    private BigDecimal valorOriginal;

    @Schema(hidden = true)
    private BigDecimal valorParcela;

    @Schema(hidden = true)
    private BigDecimal valorParcelado;

    @Schema(description = "Quantidade de parcelas", example = "12")
    private Integer quantidadeParcelas;

    @Schema(hidden = true)
    private Integer parcelasPagas;

    @Schema(hidden = true)
    private LocalDate dataInicio;

    @Schema(description = "Tipo de juros", example = "SIMPLES", allowableValues = {"SIMPLES", "COMPOSTO"})
    private ParcelamentoJurosTipo tipoJuros;

    @Schema(description = "Taxa de juros mensal", example = "2.5")
    private BigDecimal taxaJuros;

    @Schema(hidden = true)
    @JsonIgnore
    @OneToOne(mappedBy = "parcelamento")
    private DespesaModel despesa;

}
