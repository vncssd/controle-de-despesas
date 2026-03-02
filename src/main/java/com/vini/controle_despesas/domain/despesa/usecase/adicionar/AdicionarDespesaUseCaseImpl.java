package com.vini.controle_despesas.domain.despesa.usecase.adicionar;

import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.parcelamento.service.CalcularValorTotalService;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionarDespesaUseCaseImpl implements AdicionarDespesaUseCase {

    private DespesaMapper despesaMapper;
    private DespesaRepository despesaRepository;
    private CalcularValorTotalService calcularValorTotalService;

    public AdicionarDespesaUseCaseImpl(DespesaMapper despesaMapper, DespesaRepository despesaRepository, CalcularValorTotalService calcularValorTotalService) {
        this.despesaMapper = despesaMapper;
        this.despesaRepository = despesaRepository;
        this.calcularValorTotalService = calcularValorTotalService;
    }

    @Override
    @Transactional
    public DespesaDTO execute(DespesaDTO despesaDTO){
        DespesaModel despesaModel = despesaMapper.map(despesaDTO);
        if (despesaDTO.getTipo().equals(DespesaTipo.PARCELADA)){
            despesaModel.setValorTotal(calcularValorTotalService.calcularValorTotal(despesaDTO.getParcelamento().getTipoJuros(),
                                                                                    despesaDTO.getValorOriginal(),
                                                                                    despesaDTO.getParcelamento().getTaxaJuros(),
                                                                                    despesaDTO.getParcelamento().getQuantidadeParcelas()));
            return despesaMapper.map(despesaRepository.save(despesaModel));
        }
        return despesaMapper.map(despesaRepository.save(despesaModel));
    }

}
