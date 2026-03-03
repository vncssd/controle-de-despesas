package com.vini.controle_despesas.presentation.controller.parcelamento;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.application.parcelamento.ParcelamentoDTO;
import com.vini.controle_despesas.domain.parcelamento.usecase.adicionar.AdicionarParcelamentoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/parcelamento")
@RestController
public class AdicionarController {

    private AdicionarParcelamentoUseCase adicionarParcelamentoUseCase;

    public AdicionarController(AdicionarParcelamentoUseCase adicionarParcelamentoUseCase) {
        this.adicionarParcelamentoUseCase = adicionarParcelamentoUseCase;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> criarParcelamento (@RequestBody ParcelamentoDTO parcelamentoDTO){
        parcelamentoDTO = adicionarParcelamentoUseCase.execute(parcelamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("parcelamento criado: " + parcelamentoDTO.getDespesa().getDescricao());
    }
}
