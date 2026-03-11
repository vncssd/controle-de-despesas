package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.adicionar.AdicionarDespesaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/despesa")
@RestController
public class AdicionarDespesaController {

    private AdicionarDespesaUseCase adicionarDespesaUseCase;

    public AdicionarDespesaController(AdicionarDespesaUseCase adicionarDespesaUseCase) {
        this.adicionarDespesaUseCase = adicionarDespesaUseCase;
    }

    @Operation(
            summary = "Adicionar despesa",
            description = """
            Cria uma nova despesa à vista ou parcelada.
            
            **Regras:**
            - Despesa 'PARCELADA' deve conter o parcelamento preenchido
            - Despesa 'A_VISTA' não pode conter parcelamento
            """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Despesa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Despesa à vista não pode ter parcelamento / Despesa parcelada deve conter os dados do parcelamento"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })

    @PostMapping("/adicionar")
    public ResponseEntity<String> criarDespesa (@RequestBody DespesaDTO despesaDTO){
        despesaDTO = adicionarDespesaUseCase.execute(despesaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("despesa adicionada " + despesaDTO.getDescricao());
    }

}
