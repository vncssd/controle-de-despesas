package com.vini.controle_despesas.domain.despesa.usecase.listar;

import com.vini.controle_despesas.application.despesa.DespesaDTO;

import java.util.List;

public interface ListarDespesasUseCase {

    List<DespesaDTO> execute();

}
