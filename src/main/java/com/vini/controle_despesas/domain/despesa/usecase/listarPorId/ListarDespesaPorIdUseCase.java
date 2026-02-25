package com.vini.controle_despesas.domain.despesa.usecase.listarPorId;

import com.vini.controle_despesas.application.despesa.DespesaDTO;

public interface ListarDespesaPorIdUseCase {

    DespesaDTO execute(Long id);

}
