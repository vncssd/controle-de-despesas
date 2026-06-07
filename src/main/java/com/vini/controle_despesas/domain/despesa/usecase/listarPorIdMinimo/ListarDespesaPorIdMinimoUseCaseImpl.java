package com.vini.controle_despesas.domain.despesa.usecase.listarPorIdMinimo;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDespesaPorIdMinimoUseCaseImpl implements ListarDespesaPorIdMinimoUseCase{

    private final DespesaMapper despesaMapper;
    private final DespesaRepository despesaRepository;

    public ListarDespesaPorIdMinimoUseCaseImpl(DespesaMapper despesaMapper, DespesaRepository despesaRepository) {
        this.despesaMapper = despesaMapper;
        this.despesaRepository = despesaRepository;
    }

    @Override
    public List<DespesaDTO> execute(Long id){
        List<DespesaModel> despesas = despesaRepository.findByIdGreaterThan(id);
        return despesas.stream()
                .map(despesaMapper::map)
                .collect(Collectors.toList());
    }

}
