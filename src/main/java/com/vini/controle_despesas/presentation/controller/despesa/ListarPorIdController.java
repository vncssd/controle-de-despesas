package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.listarPorId.ListarDespesaPorIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesa")
public class ListarPorIdController {

    private ListarDespesaPorIdUseCase listarDespesaPorIdUseCase;

    public ListarPorIdController(ListarDespesaPorIdUseCase listarDespesaPorIdUseCase) {
        this.listarDespesaPorIdUseCase = listarDespesaPorIdUseCase;
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId (@PathVariable Long id){
        DespesaDTO despesaListada = listarDespesaPorIdUseCase.execute(id);
        if (despesaListada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("despesa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(despesaListada);
    }

}
