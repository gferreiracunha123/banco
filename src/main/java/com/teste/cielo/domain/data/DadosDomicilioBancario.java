package com.teste.cielo.domain.data;

import lombok.Data;

import java.io.Serializable;
@Data
public class DadosDomicilioBancario implements Serializable {

    private Integer codigoBnaco;
    private Integer numeroAgencia;
    private String numeroContaCorrente;

}
