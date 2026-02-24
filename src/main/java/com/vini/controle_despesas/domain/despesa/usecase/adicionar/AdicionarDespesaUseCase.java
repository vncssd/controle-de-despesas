package com.vini.controle_despesas.domain.despesa.usecase.adicionar;

import com.vini.controle_despesas.application.despesa.DespesaDTO;

public interface AdicionarDespesaUseCase {

    DespesaDTO execute(DespesaDTO despesaDTO);

}
