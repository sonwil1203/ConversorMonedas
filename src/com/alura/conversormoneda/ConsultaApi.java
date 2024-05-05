package com.alura.conversormoneda;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private final String API_KEY= "ddb150b233976b6a2f9d106f";
    public Moneda optenerDatos(String moneda){
       URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+moneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(),Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se encotro la mondea a cambiar");
        }
    }
}
