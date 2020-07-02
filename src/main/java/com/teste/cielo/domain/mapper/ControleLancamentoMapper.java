package com.teste.cielo.domain.mapper;

import com.teste.cielo.domain.dto.ControleLancamentoDTO;
import com.teste.cielo.domain.data.ControleLancamento;
import com.teste.cielo.domain.data.DadosDomicilioBancario;
import com.teste.cielo.domain.data.LancamentoContaCorrenteCliente;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
@Mapper(componentModel = "spring", uses = {LancamentoContaCorrenteCliente.class,DadosDomicilioBancario.class})
public interface ControleLancamentoMapper {

    @InheritInverseConfiguration
    @Mapping(source = "lancamentoContaCorrenteCliente.nomeTipoOperacao", target = "nomeTipoOperacao")
    @Mapping(source = "lancamentoContaCorrenteCliente.numeroRemessaBanco", target = "numeroRemessaBanco")
    @Mapping(source = "lancamentoContaCorrenteCliente.nomeSituacaoRemessa", target = "nomeSituacaoRemessa")
    @Mapping(source = "lancamentoContaCorrenteCliente", target = "nomeBanco",qualifiedByName ="nomeBancoCoverter" )
    ControleLancamentoDTO entityToDTO(ControleLancamento controleLancamento, @Context String nomeBanco);

    @Named("nomeBancoCoverter")
    default String nomeBancoCoverter(LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente,@Context String nomeBanco) {
        List<String> nomes = Arrays.asList(nomeBanco,
                "Ag: ".concat(lancamentoContaCorrenteCliente.getDadosDomicilioBancario().getNumeroAgencia().toString()),
                "CC: ".concat(lancamentoContaCorrenteCliente.getDadosDomicilioBancario().getNumeroContaCorrente().toString()));
        return String.join(" ", nomes);
    }

}
