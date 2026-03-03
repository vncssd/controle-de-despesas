package com.vini.controle_despesas.domain.parcelamento.usecase.apagar;

import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApagarParcelamentoUseCaseImpl implements ApagarParcelamentoUseCase{

    private ParcelamentoRepository parcelamentoRepository;

    public ApagarParcelamentoUseCaseImpl(ParcelamentoRepository parcelamentoRepository) {
        this.parcelamentoRepository = parcelamentoRepository;
    }

    @Override
    public void execute(Long id){
        Optional<ParcelamentoModel> parcelamentoModelOptional = parcelamentoRepository.findById(id);
        if (parcelamentoModelOptional.isPresent()){
            parcelamentoRepository.deleteById(id);
        }
    }

}
