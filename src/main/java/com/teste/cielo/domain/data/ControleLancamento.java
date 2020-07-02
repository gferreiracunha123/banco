package com.teste.cielo.domain.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class ControleLancamento implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataEfetivaLancamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataLancamentoContaCorrenteCliente;
    private Integer numeroEvento;
    private String codigoIdentificadorUnico;
    private String nomeBanco;
    private Integer quantidadeLancamentoRemessa;
    private String numeroRaizCNPJ;
    private String numeroSufixoCNPJ;
    private BigDecimal valorLancamentoRemessa;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date dateLancamentoContaCorrenteCliente;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date dateEfetivaLancamento;
    private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;


}
