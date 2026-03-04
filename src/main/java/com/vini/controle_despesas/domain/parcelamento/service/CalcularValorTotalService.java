package com.vini.controle_despesas.domain.parcelamento.service;

import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoJurosTipo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalcularValorTotalService {

    private CalcularJurosService calcularJurosService;

    public CalcularValorTotalService(CalcularJurosService calcularJurosService) {
        this.calcularJurosService = calcularJurosService;
    }

    public BigDecimal calcularValorTotal(ParcelamentoJurosTipo tipoJuros, BigDecimal valorOriginal, BigDecimal taxaDeJuros, Integer quantidadeParcelas){
        return switch(tipoJuros){
            case SIMPLES -> calcularJurosService.calcularJurosSimples(valorOriginal, taxaDeJuros, quantidadeParcelas);
            case COMPOSTO -> calcularJurosService.calcularJurosCompostos(valorOriginal, taxaDeJuros, quantidadeParcelas);
        };
    }

}
