package com.vini.controle_despesas.Despesa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    private final DespesaMapper despesaMapper;
    private final DespesaRepository despesaRepository;

    public DespesaService(DespesaMapper despesaMapper, DespesaRepository despesaRepository) {
        this.despesaMapper = despesaMapper;
        this.despesaRepository = despesaRepository;
    }

    public DespesaDTO adicionarDespesa(DespesaDTO despesaDTO){
        DespesaModel despesaModel =  despesaMapper.map(despesaDTO);
        return despesaMapper.map(despesaRepository.save(despesaModel));
    }

    public List<DespesaDTO> listarDespesas(){
        List<DespesaModel> despesas = despesaRepository.findAll();
        return despesas.stream()
                .map(despesaMapper::map)
                .collect(Collectors.toList());
    }

}
