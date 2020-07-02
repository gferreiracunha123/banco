package com.teste.cielo.domain.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Extratos implements Serializable {

    private Integer indice;
    private Integer tamanhoPagina;
    private Integer totalElements;
    private TotalControleLancamento totalControleLancamento;
    private ArrayList<ControleLancamento> listaControleLancamento;


}
