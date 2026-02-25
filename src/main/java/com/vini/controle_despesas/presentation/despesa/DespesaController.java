package com.vini.controle_despesas.presentation.despesa;


import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.adicionar.AdicionarDespesaUseCase;
import com.vini.controle_despesas.domain.despesa.usecase.apagar.ApagarDespesaUseCase;
import com.vini.controle_despesas.domain.despesa.usecase.listar.ListarDespesasUseCase;
import com.vini.controle_despesas.domain.despesa.usecase.listarPorId.ListarDespesaPorIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    private final ListarDespesaPorIdUseCase listarDespesaPorIdUseCase;
    private AdicionarDespesaUseCase adicionarDespesaUseCase;
    private ListarDespesasUseCase listarDespesasUseCase;
    private ApagarDespesaUseCase apagarDespesaUseCase;

    public DespesaController(AdicionarDespesaUseCase adicionarDespesaUseCase, ListarDespesasUseCase listarDespesasUseCase, ListarDespesaPorIdUseCase listarDespesaPorIdUseCase) {
        this.adicionarDespesaUseCase = adicionarDespesaUseCase;
        this.listarDespesasUseCase = listarDespesasUseCase;
        this.listarDespesaPorIdUseCase = listarDespesaPorIdUseCase;
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
