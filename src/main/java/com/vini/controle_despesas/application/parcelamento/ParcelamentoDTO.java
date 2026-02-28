package com.vini.controle_despesas.application.parcelamento;

import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoJurosTipo;
import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelamentoDTO {

    private Long id;
    private ParcelamentoStatus parcelamentoStatus;
    private BigDecimal valorOriginal;
    private BigDecimal valorParcela;
    private BigDecimal valorParcelado;
    private Integer quantidadeParcelas;
    private Integer parcelasPagas;
    private LocalDate dataInicio;
    private ParcelamentoJurosTipo tipoJuros;


}
