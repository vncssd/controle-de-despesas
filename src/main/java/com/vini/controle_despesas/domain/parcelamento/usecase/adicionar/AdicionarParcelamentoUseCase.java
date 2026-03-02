package com.vini.controle_despesas.domain.parcelamento.usecase.adicionar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;

public interface AdicionarParcelamentoUseCase {

    ParcelamentoDTO execute (ParcelamentoDTO parcelamentoDTO);

}
