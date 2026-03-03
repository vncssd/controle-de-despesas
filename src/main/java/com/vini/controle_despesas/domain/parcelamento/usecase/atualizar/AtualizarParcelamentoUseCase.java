package com.vini.controle_despesas.domain.parcelamento.usecase.atualizar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;

public interface AtualizarParcelamentoUseCase {

    ParcelamentoDTO execute (Long id, ParcelamentoDTO parcelamentoDTO);

}
