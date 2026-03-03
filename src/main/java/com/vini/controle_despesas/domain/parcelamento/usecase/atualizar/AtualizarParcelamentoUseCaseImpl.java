package com.vini.controle_despesas.domain.parcelamento.usecase.atualizar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.application.parcelamento.ParcelamentoMapper;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtualizarParcelamentoUseCaseImpl implements AtualizarParcelamentoUseCase {

    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoMapper parcelamentoMapper;

    public AtualizarParcelamentoUseCaseImpl(ParcelamentoRepository parcelamentoRepository, ParcelamentoMapper parcelamentoMapper) {
        this.parcelamentoRepository = parcelamentoRepository;
        this.parcelamentoMapper = parcelamentoMapper;
    }

    @Override
    @Transactional
    public ParcelamentoDTO execute(Long id, ParcelamentoDTO parcelamentoDTO){
        Optional<ParcelamentoModel> parcelamentoModelOptional = parcelamentoRepository.findById(id);
        if (parcelamentoModelOptional.isEmpty()){
            return null;
        }
        ParcelamentoModel parcelamentoAtualizado = parcelamentoMapper.map(parcelamentoDTO);
        parcelamentoAtualizado.setId(id);
        ParcelamentoModel parcelamentoSalvo = parcelamentoRepository.save(parcelamentoAtualizado);
        return parcelamentoMapper.map(parcelamentoSalvo);
    }


}
