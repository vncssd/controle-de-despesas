package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.atualizar.AtualizarDespesaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/despesa")
public class AtualizarController {

    private  AtualizarDespesaUseCase atualizarDespesaUseCase;

    public AtualizarController(AtualizarDespesaUseCase atualizarDespesaUseCase) {
        this.atualizarDespesaUseCase = atualizarDespesaUseCase;
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar (@PathVariable Long id, @RequestBody DespesaDTO despesaDTO){
        atualizarDespesaUseCase.execute(id, despesaDTO);
        if (atualizarDespesaUseCase != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("despesa com id "+id+ " atualizada!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("despesa com id "+id+ " atualizada!");
    }

}
