package com.vini.controle_despesas.domain.parcelamento.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularValorParcelaService {

    public BigDecimal calcularValorParcela(BigDecimal valorParcelado, Integer quantidadeParcelas){
        return valorParcelado.divide(BigDecimal.valueOf(quantidadeParcelas), 2, RoundingMode.HALF_UP);
    }
}
