package com.vini.controle_despesas.infrastructure.repository;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {
}
