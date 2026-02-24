package com.vini.controle_despesas.domain.despesa.services;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import org.springframework.stereotype.Component;

@Component
public class DespesaMapper {

    public DespesaModel map(DespesaDTO despesaDTO){

        DespesaModel despesaModel = new DespesaModel();

        despesaModel.setId(despesaDTO.getId());
        despesaModel.setDescricao(despesaDTO.getDescricao());
        despesaModel.setValor(despesaDTO.getValor());
        despesaModel.setTipo(despesaDTO.getTipo());
        despesaModel.setPrioridade(despesaDTO.getPrioridade());
        despesaModel.setStatus(despesaDTO.getStatus());
        despesaModel.setDataVencimento(despesaDTO.getDataVencimento());

        return despesaModel;
    }

    public DespesaDTO map(DespesaModel despesaModel){

        DespesaDTO despesaDTO = new DespesaDTO();

        despesaDTO.setId(despesaModel.getId());
        despesaDTO.setDescricao(despesaModel.getDescricao());
        despesaDTO.setValor(despesaModel.getValor());
        despesaDTO.setTipo(despesaModel.getTipo());
        despesaDTO.setPrioridade(despesaModel.getPrioridade());
        despesaDTO.setStatus(despesaModel.getStatus());
        despesaDTO.setDataVencimento(despesaModel.getDataVencimento());

        return despesaDTO;
    }
}
