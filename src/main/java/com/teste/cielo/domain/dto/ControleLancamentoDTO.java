package com.teste.cielo.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class ControleLancamentoDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataEfetivaLancamento;
    private String nomeTipoOperacao;
    private String numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataLancamentoContaCorrenteCliente;
    private String nomeBanco;
    private BigDecimal valorLancamentoRemessa;


}
