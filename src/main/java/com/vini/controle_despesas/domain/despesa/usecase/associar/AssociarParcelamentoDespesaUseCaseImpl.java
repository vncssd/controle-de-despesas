package com.vini.controle_despesas.domain.despesa.usecase.associar;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociarParcelamentoDespesaUseCaseImpl implements AssociarParcelemantoDespesaUseCase{

    private final DespesaRepository despesaRepository;
    private final ParcelamentoRepository parcelamentoRepository;
    private final DespesaMapper despesaMapper;

    public AssociarParcelamentoDespesaUseCaseImpl(DespesaRepository despesaRepository, ParcelamentoRepository parcelamentoRepository, DespesaMapper despesaMapper) {
        this.despesaRepository = despesaRepository;
        this.parcelamentoRepository = parcelamentoRepository;
        this.despesaMapper = despesaMapper;
    }

    @Override
    public DespesaDTO execute(Long despesaId, Long parcelamentoId) {

        DespesaModel despesaModel = despesaRepository.findById(despesaId).orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
        ParcelamentoModel parcelamentoModel = parcelamentoRepository.findById(parcelamentoId).orElseThrow(() -> new RuntimeException("Parcelamento não encontrado"));

        if (despesaModel.getParcelamento() != null) {
            throw new RuntimeException("Despesa já possui um parcelamento associado");
        }

        despesaModel.setParcelamento(parcelamentoModel);
        despesaModel.setValorTotal(parcelamentoModel.getValorParcelado());

        DespesaModel despesaAtualizada = despesaRepository.save(despesaModel);
        return despesaMapper.map(despesaAtualizada);
    }
}
