package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.usecase.listar.ListarDespesasUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/despesa")
public class ListarController {

    private ListarDespesasUseCase listarDespesasUseCase;

    public ListarController(ListarDespesasUseCase listarDespesasUseCase) {
        this.listarDespesasUseCase = listarDespesasUseCase;
    }

    @GetMapping("/listar")
    public ResponseEntity<List> listarDespesas (){
        List<DespesaDTO> despesasList = listarDespesasUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK)
                .body(despesasList);
    }

}
