package com.vini.controle_despesas.infrastructure.despesa;

import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {
    Long id(Long id);

    List<DespesaModel> findByTipo(DespesaTipo despesaTipo);

}
