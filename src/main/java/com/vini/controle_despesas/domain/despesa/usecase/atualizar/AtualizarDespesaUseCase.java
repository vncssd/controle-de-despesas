package com.vini.controle_despesas.domain.despesa.usecase.atualizar;

import com.vini.controle_despesas.application.despesa.DespesaDTO;

public interface AtualizarDespesaUseCase {

    DespesaDTO execute(Long id, DespesaDTO despesaDTO);

}
