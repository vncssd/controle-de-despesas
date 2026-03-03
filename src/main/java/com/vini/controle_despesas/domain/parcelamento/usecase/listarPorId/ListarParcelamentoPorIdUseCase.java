package com.vini.controle_despesas.domain.parcelamento.usecase.listarPorId;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;

public interface ListarParcelamentoPorIdUseCase {

    ParcelamentoDTO execute(Long id);

}
