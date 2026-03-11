package com.vini.controle_despesas.application.parcelamento;

import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import org.springframework.stereotype.Component;

@Component
public class ParcelamentoMapper {

    public ParcelamentoModel map(ParcelamentoDTO parcelamentoDTO){

        ParcelamentoModel parcelamentoModel = new ParcelamentoModel();

        parcelamentoModel.setId(parcelamentoDTO.getId());
        parcelamentoModel.setParcelamentoStatus(parcelamentoDTO.getParcelamentoStatus());
        parcelamentoModel.setValorOriginal(parcelamentoDTO.getValorOriginal());
        parcelamentoModel.setValorParcela(parcelamentoDTO.getValorParcela());
        parcelamentoModel.setValorParcelado(parcelamentoDTO.getValorParcelado());
        parcelamentoModel.setQuantidadeParcelas(parcelamentoDTO.getQuantidadeParcelas());
        parcelamentoModel.setParcelasPagas(parcelamentoDTO.getParcelasPagas());
        parcelamentoModel.setDataInicio(parcelamentoDTO.getDataInicio());
        parcelamentoModel.setTipoJuros(parcelamentoDTO.getTipoJuros());
        parcelamentoModel.setTaxaJuros(parcelamentoDTO.getTaxaJuros());
        parcelamentoModel.setDespesa(parcelamentoModel.getDespesa());

        return parcelamentoModel;

    }

    public ParcelamentoDTO map(ParcelamentoModel parcelamentoModel){

        ParcelamentoDTO parcelamentoDTO = new ParcelamentoDTO();

        parcelamentoDTO.setId(parcelamentoModel.getId());
        parcelamentoDTO.setParcelamentoStatus(parcelamentoModel.getParcelamentoStatus());
        parcelamentoDTO.setValorOriginal(parcelamentoModel.getValorOriginal());
        parcelamentoDTO.setValorParcela(parcelamentoModel.getValorParcela());
        parcelamentoDTO.setValorParcelado(parcelamentoModel.getValorParcelado());
        parcelamentoDTO.setQuantidadeParcelas(parcelamentoModel.getQuantidadeParcelas());
        parcelamentoDTO.setParcelasPagas(parcelamentoModel.getParcelasPagas());
        parcelamentoDTO.setDataInicio(parcelamentoModel.getDataInicio());
        parcelamentoDTO.setTipoJuros(parcelamentoModel.getTipoJuros());
        parcelamentoDTO.setTaxaJuros(parcelamentoModel.getTaxaJuros());
        parcelamentoDTO.setDespesa(parcelamentoDTO.getDespesa());

        return parcelamentoDTO;

    }



}
