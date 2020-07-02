package com.teste.cielo.controller;

import com.teste.cielo.domain.dto.ControleLancamentoDTO;
import com.teste.cielo.domain.data.ControleLancamento;
import com.teste.cielo.service.ExtratoService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = {MockServletContext.class})
class BankControllerTest extends AbstractTestNGSpringContextTests {
    @InjectMocks
    private ControleLancamento controller;

    @Mock
    private ExtratoService extractService;

    @Autowired
    private MockServletContext servletContext;

    protected MockMvc mvc;

    protected HttpHeaders httpHeaders;

    @BeforeMethod
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
        final GenericWebApplicationContext context = new GenericWebApplicationContext(servletContext);
        context.refresh();
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void buscarExtratos() throws Exception {
        Mockito.when(extractService.extratos()).thenReturn(Arrays.asList(new ControleLancamentoDTO()));
        ResultActions perform = mvc.perform(get("/api/extrato")
                .headers(httpHeaders).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        perform.andExpect(status().isOk());
    }


}
