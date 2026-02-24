package com.vini.controle_despesas.presentation.despesa;


import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.adicionar.AdicionarDespesaUseCase;
import com.vini.controle_despesas.domain.despesa.usecase.listar.ListarDespesasUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    private AdicionarDespesaUseCase adicionarDespesaUseCase;
    private ListarDespesasUseCase listarDespesasUseCase;

    public DespesaController(AdicionarDespesaUseCase adicionarDespesaUseCase, ListarDespesasUseCase listarDespesasUseCase) {
        this.adicionarDespesaUseCase = adicionarDespesaUseCase;
        this.listarDespesasUseCase = listarDespesasUseCase;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> criarDespesa (@RequestBody DespesaDTO despesaDTO){
        despesaDTO = adicionarDespesaUseCase.execute(despesaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("despesa adicionada " + despesaDTO.getDescricao());
    }

    @GetMapping("/listar")
    public ResponseEntity<List> listarDespesas (){
        List<DespesaDTO> despesasList = listarDespesasUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(despesasList);
    }

}
