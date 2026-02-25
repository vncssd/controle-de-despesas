package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.adicionar.AdicionarDespesaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdicionarController {

    private AdicionarDespesaUseCase adicionarDespesaUseCase;

    public AdicionarController(AdicionarDespesaUseCase adicionarDespesaUseCase) {
        this.adicionarDespesaUseCase = adicionarDespesaUseCase;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> criarDespesa (@RequestBody DespesaDTO despesaDTO){
        despesaDTO = adicionarDespesaUseCase.execute(despesaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("despesa adicionada " + despesaDTO.getDescricao());
    }

}
