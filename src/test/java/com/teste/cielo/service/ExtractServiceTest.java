package com.teste.cielo.service;


import com.teste.cielo.domain.dto.ControleLancamentoDTO;
import com.teste.cielo.domain.data.ControleLancamento;
import com.teste.cielo.domain.mapper.ControleLancamentoMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@AutoConfigureMockMvc
@SpringBootTest
class ExtractServiceTest extends AbstractTestNGSpringContextTests {
    @InjectMocks
    private ExtratoService extractService;

    @Mock
    private ControleLancamentoMapper controleLancamentoMapper;

    @BeforeTest
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void extratos() {
        Mockito.when(controleLancamentoMapper
                .entityToDTO(Mockito.any(ControleLancamento.class),Mockito.anyString()))
                .thenReturn(new ControleLancamentoDTO());
        Assert.notEmpty(extractService.extratos());

    }
}
