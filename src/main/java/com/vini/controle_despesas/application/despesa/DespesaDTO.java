package com.vini.controle_despesas.application.despesa;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.domain.despesa.enums.DespesaPrioridade;
import com.vini.controle_despesas.domain.despesa.enums.DespesaStatus;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados para criação de uma despesa")

public class DespesaDTO {

    @Schema(hidden = true)
    private Long id;

    @Schema(description = "Descrição da despesa", example = "Conta de Luz")
    private String descricao;

    @Schema(description = "Valor original da despesa", example = "350.00")
    private BigDecimal valorOriginal;

    @Schema(hidden = true)
    private BigDecimal valorTotal;

    @Schema(description = "Tipo da despesa", example = "PARCELADA", allowableValues = {"A_VISTA", "PARCELADA"})
    private DespesaTipo tipo;

    @Schema(description = "Prioridade da despesa", example = "ALTA", allowableValues = {"ALTA", "MEDIA", "BAIXA"})
    private DespesaPrioridade prioridade;

    @Schema(description = "Status da despesa", example = "PENDENTE", allowableValues = {"PENDENTE", "PAGO", "ATRASADO"})
    private DespesaStatus status;

    @Schema(description = "Data de vencimento", example = "2026-04-10")
    private LocalDate dataVencimento;

    @Schema(description = "Dados do parcelamento, obrigatório quando tipo for PARCELADA")
    private ParcelamentoDTO parcelamento;

}
