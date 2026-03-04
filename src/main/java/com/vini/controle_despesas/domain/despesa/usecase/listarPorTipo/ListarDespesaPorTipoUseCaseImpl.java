package com.vini.controle_despesas.domain.despesa.usecase.listarPorTipo;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDespesaPorTipoUseCaseImpl implements ListarDespesaPorTipoUseCase{

    private final DespesaRepository despesaRepository;
    private final DespesaMapper despesaMapper;

    public ListarDespesaPorTipoUseCaseImpl(DespesaRepository despesaRepository, DespesaMapper despesaMapper) {
        this.despesaRepository = despesaRepository;
        this.despesaMapper = despesaMapper;
    }

    @Override
    public List<DespesaDTO> execute(DespesaTipo despesaTipo){
        List<DespesaModel> despesas = despesaRepository.findByTipo(despesaTipo);
        return despesas.stream()
                .map(despesaMapper::map)
                .collect(Collectors.toList());
    }

}
