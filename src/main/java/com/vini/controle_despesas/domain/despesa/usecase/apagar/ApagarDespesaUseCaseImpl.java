package com.vini.controle_despesas.domain.despesa.usecase.apagar;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApagarDespesaUseCaseImpl implements ApagarDespesaUseCase{

    private DespesaRepository despesaRepository;

    public ApagarDespesaUseCaseImpl(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    @Override
    public void execute(Long id){
        Optional<DespesaModel> despesaModelOptional = despesaRepository.findById(id);
        if (despesaModelOptional.isPresent()){
            despesaRepository.deleteById(id);
        }
    }

}
