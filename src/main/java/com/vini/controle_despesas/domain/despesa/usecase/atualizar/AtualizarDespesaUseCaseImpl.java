package com.vini.controle_despesas.domain.despesa.usecase.atualizar;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtualizarDespesaUseCaseImpl implements AtualizarDespesaUseCase{

    private DespesaRepository despesaRepository;
    private DespesaMapper despesaMapper;

    @Override
    @Transactional
    public DespesaDTO execute(Long id, DespesaDTO despesaDTO){
        Optional<DespesaModel> despesaModelOptional = despesaRepository.findById(id);
        if (despesaModelOptional.isEmpty()){
            return null;
        }
        DespesaModel despesaAtualizada = despesaMapper.map(despesaDTO);
        despesaAtualizada.setId(id);
        DespesaModel despesaSalva = despesaRepository.save(despesaAtualizada);
        return despesaMapper.map(despesaSalva);
    }

}
