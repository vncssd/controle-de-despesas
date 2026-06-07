package com.vini.controle_despesas.application.despesa;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoMapper;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DespesaMapper {

    private final ParcelamentoMapper parcelamentoMapper;

    public DespesaModel map(DespesaDTO despesaDTO) {
        DespesaModel despesaModel = new DespesaModel();
        despesaModel.setId(despesaDTO.getId());
        despesaModel.setDescricao(despesaDTO.getDescricao());
        despesaModel.setValorOriginal(despesaDTO.getValorOriginal());
        despesaModel.setValorTotal(despesaDTO.getValorTotal());
        despesaModel.setTipo(despesaDTO.getTipo());
        despesaModel.setPrioridade(despesaDTO.getPrioridade());
        despesaModel.setStatus(despesaDTO.getStatus());
        despesaModel.setDataVencimento(despesaDTO.getDataVencimento());

        if (despesaDTO.getParcelamento() != null) {
            despesaModel.setParcelamento(
                    parcelamentoMapper.mapToModel(despesaDTO.getParcelamento())
            );
        }

        return despesaModel;
    }

    public DespesaDTO map(DespesaModel despesaModel) {
        DespesaDTO despesaDTO = new DespesaDTO();
        despesaDTO.setId(despesaModel.getId());
        despesaDTO.setDescricao(despesaModel.getDescricao());
        despesaDTO.setValorOriginal(despesaModel.getValorOriginal());
        despesaDTO.setValorTotal(despesaModel.getValorTotal());
        despesaDTO.setTipo(despesaModel.getTipo());
        despesaDTO.setPrioridade(despesaModel.getPrioridade());
        despesaDTO.setStatus(despesaModel.getStatus());
        despesaDTO.setDataVencimento(despesaModel.getDataVencimento());

        if (despesaModel.getParcelamento() != null) {
            despesaDTO.setParcelamento(
                    parcelamentoMapper.mapToDTO(despesaModel.getParcelamento())
            );
        }

        return despesaDTO;
    }
}