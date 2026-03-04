package com.vini.controle_despesas.domain.despesa.usecase.adicionar;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoMapper;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.despesa.DespesaMapper;
import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoStatus;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import com.vini.controle_despesas.domain.parcelamento.service.CalcularValorParcelaService;
import com.vini.controle_despesas.domain.parcelamento.service.CalcularValorTotalService;
import com.vini.controle_despesas.infrastructure.despesa.DespesaRepository;
import com.vini.controle_despesas.infrastructure.parcelamento.ParcelamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AdicionarDespesaUseCaseImpl implements AdicionarDespesaUseCase {

    private final DespesaMapper despesaMapper;
    private final ParcelamentoMapper parcelamentoMapper;
    private final DespesaRepository despesaRepository;
    private final ParcelamentoRepository parcelamentoRepository;
    private final CalcularValorTotalService calcularValorTotalService;
    private final CalcularValorParcelaService calcularValorParcelaService;

    public AdicionarDespesaUseCaseImpl(DespesaMapper despesaMapper, ParcelamentoMapper parcelamentoMapper, DespesaRepository despesaRepository, ParcelamentoRepository parcelamentoRepository, CalcularValorTotalService calcularValorTotalService, CalcularValorParcelaService calcularValorParcelaService) {
        this.despesaMapper = despesaMapper;
        this.parcelamentoMapper = parcelamentoMapper;
        this.despesaRepository = despesaRepository;
        this.parcelamentoRepository = parcelamentoRepository;
        this.calcularValorTotalService = calcularValorTotalService;
        this.calcularValorParcelaService = calcularValorParcelaService;
    }

    @Override
    @Transactional
    public DespesaDTO execute(DespesaDTO despesaDTO){
        DespesaModel despesaModel = despesaMapper.map(despesaDTO);

        if (despesaDTO.getTipo() == DespesaTipo.PARCELADA && despesaDTO.getParcelamento() == null) {
            throw new RuntimeException("Despesa parcelada deve conter os dados do parcelamento");
        }

        if (despesaDTO.getTipo() == DespesaTipo.A_VISTA && despesaDTO.getParcelamento() != null) {
            throw new RuntimeException("Despesa à vista não pode ter parcelamento");
        }

        if (despesaDTO.getTipo().equals(DespesaTipo.PARCELADA)){

            BigDecimal valorTotal = calcularValorTotalService.calcularValorTotal(
                    despesaDTO.getParcelamento().getTipoJuros(),
                    despesaDTO.getValorOriginal(),
                    despesaDTO.getParcelamento().getTaxaJuros(),
                    despesaDTO.getParcelamento().getQuantidadeParcelas()
            );

            despesaModel.setValorTotal(valorTotal);

            ParcelamentoModel parcelamentoModel = new ParcelamentoModel();
            parcelamentoModel.setParcelamentoStatus(ParcelamentoStatus.EM_ANDAMENTO);
            parcelamentoModel.setValorOriginal(despesaDTO.getValorOriginal());
            parcelamentoModel.setValorParcela(calcularValorParcelaService.calcularValorParcela(valorTotal, despesaDTO.getParcelamento().getQuantidadeParcelas()));
            parcelamentoModel.setQuantidadeParcelas(despesaDTO.getParcelamento().getQuantidadeParcelas());
            parcelamentoModel.setParcelasPagas(0);
            parcelamentoModel.setDataInicio(LocalDate.now());
            parcelamentoModel.setTipoJuros(despesaDTO.getParcelamento().getTipoJuros());
            parcelamentoModel.setTaxaJuros(despesaDTO.getParcelamento().getTaxaJuros());

            parcelamentoMapper.map(parcelamentoRepository.save(parcelamentoModel));
            despesaModel.setParcelamento(parcelamentoModel);

        }
        return despesaMapper.map(despesaRepository.save(despesaModel));
    }

}
