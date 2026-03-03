package com.vini.controle_despesas.domain.parcelamento.usecase.adicionar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.application.parcelamento.ParcelamentoMapper;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionarParcelamentoUseCaseImpl implements AdicionarParcelamentoUseCase {

    private final ParcelamentoMapper parcelamentoMapper;
    private final ParcelamentoRepository parcelamentoRepository;

    public AdicionarParcelamentoUseCaseImpl(ParcelamentoMapper parcelamentoMapper, ParcelamentoRepository parcelamentoRepository) {
        this.parcelamentoMapper = parcelamentoMapper;
        this.parcelamentoRepository = parcelamentoRepository;
    }

    @Override
    @Transactional
    public ParcelamentoDTO execute(ParcelamentoDTO parcelamentoDTO){
        ParcelamentoModel parcelamentoModel = parcelamentoMapper.map(parcelamentoDTO);
        return parcelamentoMapper.map(parcelamentoRepository.save(parcelamentoModel));
    }

}
