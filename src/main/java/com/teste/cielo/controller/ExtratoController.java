package com.teste.cielo.controller;

import com.teste.cielo.domain.dto.ControleLancamentoDTO;
import com.teste.cielo.service.ExtratoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/api")
@Api(value ="/api", produces = APPLICATION_JSON_UTF8_VALUE)
public class ExtratoController {

    @Autowired
    private ExtratoService extractService;

    @ApiOperation(value = "Este metodo retorna um lista de extratos bancarios do cliente", nickname = "buscarExtratos")
    @CrossOrigin
    @GetMapping(path = "extratos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ControleLancamentoDTO>> buscarExtratos() {
        return new ResponseEntity<>(extractService.extratos(), HttpStatus.OK);
    }
}
