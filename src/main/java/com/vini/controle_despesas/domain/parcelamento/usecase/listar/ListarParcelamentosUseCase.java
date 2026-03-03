package com.vini.controle_despesas.domain.parcelamento.usecase.listar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;

import java.util.List;

public interface ListarParcelamentosUseCase {

    List<ParcelamentoDTO> execute();

}
