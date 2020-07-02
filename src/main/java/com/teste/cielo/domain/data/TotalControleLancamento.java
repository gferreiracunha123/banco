package com.teste.cielo.domain.data;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class TotalControleLancamento implements Serializable {

    private Integer quantidadeLancamentos;
    private Integer quantidadeRemessas;
    private BigDecimal valorLancamentos;


}
