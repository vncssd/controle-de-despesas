package com.vini.controle_despesas.domain.parcelamento.usecase.listarPorId;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.application.parcelamento.ParcelamentoMapper;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListarParcelamentoPorIdUseCaseImpl implements ListarParcelamentoPorIdUseCase {

    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoMapper parcelamentoMapper;

    public ListarParcelamentoPorIdUseCaseImpl(ParcelamentoRepository parcelamentoRepository, ParcelamentoMapper parcelamentoMapper) {
        this.parcelamentoRepository = parcelamentoRepository;
        this.parcelamentoMapper = parcelamentoMapper;
    }

    @Override
    public ParcelamentoDTO execute(Long id){
        Optional<ParcelamentoModel> parcelamentoModelOptional = parcelamentoRepository.findById(id);
        return parcelamentoModelOptional.map(parcelamentoMapper::map).orElse(null);
    }

}
