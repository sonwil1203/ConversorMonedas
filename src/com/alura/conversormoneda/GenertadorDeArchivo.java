package com.alura.conversormoneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenertadorDeArchivo {
    public void guardarJson(List<Conversiones> listaConversiones) throws IOException {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create(); //crea un geson para leer formato json mas ordenada
        FileWriter escritura= new FileWriter("ReporteConversiones.Json");
        escritura.write(gson.toJson(listaConversiones));
        escritura.close();
    }
}
