package com.vini.controle_despesas.infrastructure.parcelamento;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelamentoRepository extends JpaRepository<DespesaModel, Long> {
}
