package com.vini.controle_despesas.domain.despesa.usecase.adicionar;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionarDespesaUseCaseImpl implements AdicionarDespesaUseCase {

    private DespesaMapper despesaMapper;
    private DespesaRepository despesaRepository;

    public AdicionarDespesaUseCaseImpl(DespesaMapper despesaMapper, DespesaRepository despesaRepository) {
        this.despesaMapper = despesaMapper;
        this.despesaRepository = despesaRepository;
    }

    @Override
    @Transactional
    public DespesaDTO execute(DespesaDTO despesaDTO){
        DespesaModel despesaModel = despesaMapper.map(despesaDTO);
        return despesaMapper.map(despesaRepository.save(despesaModel));
    }

}
