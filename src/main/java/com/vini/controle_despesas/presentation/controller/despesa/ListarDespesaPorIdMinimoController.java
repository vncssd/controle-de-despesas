package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.listarPorIdMinimo.ListarDespesaPorIdMinimoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/despesa")
public class ListarDespesaPorIdMinimoController {

    private final ListarDespesaPorIdMinimoUseCase listarDespesaPorIdMinimoUseCase;

    public ListarDespesaPorIdMinimoController(ListarDespesaPorIdMinimoUseCase listarDespesaPorIdMinimoUseCase) {
        this.listarDespesaPorIdMinimoUseCase = listarDespesaPorIdMinimoUseCase;
    }

    @GetMapping("/listar/min/{id}")
    public ResponseEntity<?> listarPorIdMinimo (@PathVariable Long id){
        List<DespesaDTO> despesaListada = listarDespesaPorIdMinimoUseCase.execute(id);
        if (despesaListada == null || despesaListada.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.emptyList());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(despesaListada);
    }

}
