package com.vini.controle_despesas.infrastructure.parcelamento;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import com.vini.controle_despesas.domain.parcelamento.model.ParcelamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelamentoRepository extends JpaRepository<ParcelamentoModel, Long> {
}
