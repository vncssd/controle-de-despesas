package com.vini.controle_despesas.presentation.controller.despesa;

import com.vini.controle_despesas.application.despesa.DespesaDTO;
import com.vini.controle_despesas.domain.despesa.enums.DespesaTipo;
import com.vini.controle_despesas.domain.despesa.usecase.listarPorTipo.ListarDespesaPorTipoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/despesa")
public class ListarDespesaPorTipoController {

    private final ListarDespesaPorTipoUseCase listarDespesaPorTipoUseCase;

    public ListarDespesaPorTipoController(ListarDespesaPorTipoUseCase listarDespesaPorTipoUseCase) {
        this.listarDespesaPorTipoUseCase = listarDespesaPorTipoUseCase;
    }

    @GetMapping("/listar/tipo/{tipo}")
    public ResponseEntity<?> listarPorTipo(@PathVariable DespesaTipo tipo){
        List<DespesaDTO> despesasList = listarDespesaPorTipoUseCase.execute(tipo);
        if (despesasList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("despesa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(despesasList);
    }


}
