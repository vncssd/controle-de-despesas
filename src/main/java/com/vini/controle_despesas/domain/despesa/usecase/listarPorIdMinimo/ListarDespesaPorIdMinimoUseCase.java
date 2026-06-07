package com.vini.controle_despesas.domain.despesa.usecase.listarPorIdMinimo;

import com.vini.controle_despesas.application.despesa.DespesaDTO;

import java.util.List;

public interface ListarDespesaPorIdMinimoUseCase {

    List<DespesaDTO> execute(Long id);

}
