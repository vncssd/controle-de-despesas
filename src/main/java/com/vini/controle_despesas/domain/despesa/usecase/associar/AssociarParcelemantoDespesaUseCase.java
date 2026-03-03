package com.vini.controle_despesas.domain.despesa.usecase.associar;

import com.vini.controle_despesas.application.despesa.DespesaDTO;

public interface AssociarParcelemantoDespesaUseCase {

    DespesaDTO execute(Long despesaId, Long parcelamentoId);

}
