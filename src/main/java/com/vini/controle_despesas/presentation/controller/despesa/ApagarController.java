package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.domain.despesa.usecase.apagar.ApagarDespesaUseCase;
import com.vini.controle_despesas.domain.despesa.usecase.listarPorId.ListarDespesaPorIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesa")
public class ApagarController {

    private ApagarDespesaUseCase apagarDespesaUseCase;
    private  ListarDespesaPorIdUseCase listarDespesaPorIdUseCase;

    public ApagarController(ApagarDespesaUseCase apagarDespesaUseCase) {
        this.apagarDespesaUseCase = apagarDespesaUseCase;
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<String> apagarPorId (@PathVariable Long id){
        apagarDespesaUseCase.execute(id);

        if (listarDespesaPorIdUseCase.execute(id) != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("despesa apagada id: " + id);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("despesa com id " +id+ " não encontrada");
        }
    }


}
