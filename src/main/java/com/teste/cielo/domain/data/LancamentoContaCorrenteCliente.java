package com.teste.cielo.domain.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
@Data
public class LancamentoContaCorrenteCliente implements Serializable {

    private String numeroRemessaBanco;
    private ArrayList<String> dadosAnaliticoLancamentoFinanceiroCliente;
    private String nomeSituacaoRemessa;
    private DadosDomicilioBancario dadosDomicilioBancario;
    private String nomeTipoOperacao;

}
