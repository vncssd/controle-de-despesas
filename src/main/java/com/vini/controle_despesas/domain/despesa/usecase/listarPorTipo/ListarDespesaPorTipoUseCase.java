package com.vini.controle_despesas.domain.despesa.usecase.listarPorTipo;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;

import java.util.List;

public interface ListarDespesaPorTipoUseCase {

    List<DespesaDTO> execute(DespesaTipo despesaTipo);

}
