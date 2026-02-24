package com.vini.controle_despesas.domain.despesa.usecase.listar;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDespesasUseCaseImpl implements ListarDespesasUseCase {

    private DespesaRepository despesaRepository;
    private DespesaMapper despesaMapper;

    public ListarDespesasUseCaseImpl(DespesaRepository despesaRepository, DespesaMapper despesaMapper) {
        this.despesaRepository = despesaRepository;
        this.despesaMapper = despesaMapper;
    }

    @Override
    public List<DespesaDTO> execute(){
        List<DespesaModel> despesas = despesaRepository.findAll();
        return despesas.stream()
                .map(despesaMapper::map)
                .collect(Collectors.toList());
    }

}
