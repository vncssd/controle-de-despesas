package com.vini.controle_despesas.domain.parcelamento.service;

import com.vini.controle_despesas.domain.parcelamento.enums.ParcelamentoJurosTipo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularJurosService {

    public BigDecimal calcularValorTotal(ParcelamentoJurosTipo tipoJuros, BigDecimal valorOriginal, BigDecimal taxaDeJuros,Integer quantidadeParcelas){
        return switch(tipoJuros){
            case SIMPLES -> calcularJurosSimples(valorOriginal, taxaDeJuros, quantidadeParcelas);
            case COMPOSTO -> calcularJurosCompostos(valorOriginal, taxaDeJuros, quantidadeParcelas);
        };
    }

    private BigDecimal calcularJurosSimples(BigDecimal valorOriginal, BigDecimal taxaJuros, Integer quantidadeParcelas) {
        BigDecimal taxa = taxaJuros.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal juros = valorOriginal.multiply(taxa).multiply(BigDecimal.valueOf(quantidadeParcelas));
        return valorOriginal.add(juros).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularJurosCompostos(BigDecimal valorOriginal, BigDecimal taxaJuros, Integer quantidadeParcelas) {
        BigDecimal taxa = taxaJuros.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal fator = BigDecimal.ONE.add(taxa).pow(quantidadeParcelas);
        return valorOriginal.multiply(fator).setScale(2, RoundingMode.HALF_UP);
    }


}
