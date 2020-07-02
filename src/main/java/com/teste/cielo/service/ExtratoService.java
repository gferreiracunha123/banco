package com.teste.cielo.service;

import com.teste.cielo.domain.dto.ControleLancamentoDTO;
import com.teste.cielo.domain.data.Extratos;
import com.teste.cielo.domain.mapper.ControleLancamentoMapper;
import com.teste.cielo.util.ConverterJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtratoService {

    @Autowired
    private ControleLancamentoMapper controleLancamentoMapper;

    public List<ControleLancamentoDTO> extratos() {
        try {
            return ((Extratos) new ConverterJson()
                    .conveter("lancamento-conta-legado.json", Extratos.class))
                    .getListaControleLancamento().stream()
                    .map(aux -> controleLancamentoMapper.entityToDTO(aux, aux.getNomeBanco()))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }
}
