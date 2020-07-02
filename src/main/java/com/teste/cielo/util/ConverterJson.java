package com.teste.cielo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;

public class ConverterJson <T> {
    public T conveter(String nomeArquivo, Class tClass) throws UnsupportedEncodingException {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();
        InputStream inputStream = ConverterJson.class.getResourceAsStream("/static/"+nomeArquivo);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        return gson.fromJson(br, (Type) tClass);
    }
}
