package com.vini.controle_despesas.domain.despesa.usecase.listarPorId;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListarDespesaPorIdUseCaseImpl implements ListarDespesaPorIdUseCase{

    private final DespesaMapper despesaMapper;
    private DespesaRepository despesaRepository;

    public ListarDespesaPorIdUseCaseImpl(DespesaRepository despesaRepository, DespesaMapper despesaMapper) {
        this.despesaRepository = despesaRepository;
        this.despesaMapper = despesaMapper;
    }

    @Override
    public DespesaDTO execute(Long id){
        Optional<DespesaModel> despesaModelOptional = despesaRepository.findById(id);
        return despesaModelOptional.map(despesaMapper::map).orElse(null);
    }
}
