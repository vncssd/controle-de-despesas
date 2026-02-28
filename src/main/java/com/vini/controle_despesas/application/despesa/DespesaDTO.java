package com.vini.controle_despesas.application.despesa;

import com.vini.controle_despesas.domain.despesa.enums.DespesaPrioridade;
import com.vini.controle_despesas.domain.despesa.enums.DespesaStatus;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DespesaDTO {

    private Long id;
    private String descricao;
    private BigDecimal valorTotal;
    private DespesaTipo tipo;
    private DespesaPrioridade prioridade;
    private DespesaStatus status;
    private LocalDate dataVencimento;

}
