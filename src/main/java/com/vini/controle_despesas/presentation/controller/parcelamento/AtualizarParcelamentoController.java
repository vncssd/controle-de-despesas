package com.vini.controle_despesas.presentation.controller.parcelamento;

import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.domain.parcelamento.usecase.atualizar.AtualizarParcelamentoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcelamento")
public class AtualizarParcelamentoController {

    private AtualizarParcelamentoUseCase atualizarParcelamentoUseCase;

    public AtualizarParcelamentoController(AtualizarParcelamentoUseCase atualizarParcelamentoUseCase) {
        this.atualizarParcelamentoUseCase = atualizarParcelamentoUseCase;
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar (@PathVariable Long id, @RequestBody ParcelamentoDTO parcelamentoDTO){
        atualizarParcelamentoUseCase.execute(id, parcelamentoDTO);
        if (atualizarParcelamentoUseCase != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("parcelamento com id "+id+ " atualizado!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("parcelamento com id "+id+ " atualizado!");
    }

}
