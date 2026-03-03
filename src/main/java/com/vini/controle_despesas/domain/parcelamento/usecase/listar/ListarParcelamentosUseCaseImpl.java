package com.vini.controle_despesas.domain.parcelamento.usecase.listar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.application.parcelamento.ParcelamentoMapper;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarParcelamentosUseCaseImpl implements ListarParcelamentosUseCase{

    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoMapper parcelamentoMapper;

    public ListarParcelamentosUseCaseImpl(ParcelamentoRepository parcelamentoRepository, ParcelamentoMapper parcelamentoMapper) {
        this.parcelamentoRepository = parcelamentoRepository;
        this.parcelamentoMapper = parcelamentoMapper;
    }

    @Override
    public List<ParcelamentoDTO> execute(){
        List<ParcelamentoModel> parcelamentos = parcelamentoRepository.findAll();
        return parcelamentos.stream()
                .map(parcelamentoMapper::map)
                .collect(Collectors.toList());
    }

}
