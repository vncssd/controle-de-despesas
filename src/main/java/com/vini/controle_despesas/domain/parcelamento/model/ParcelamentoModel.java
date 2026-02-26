package com.vini.controle_despesas.domain.parcelamento.model;

import com.vini.controle_despesas.domain.despesa.model.DespesaModel;
import jakarta.persistence.*;

@Entity
@Table(name="tb_parcelamento")
public class ParcelamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "parcelamento")
    private DespesaModel despesa;




}
