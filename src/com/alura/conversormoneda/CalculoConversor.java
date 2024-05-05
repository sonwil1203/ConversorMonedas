package com.alura.conversormoneda;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CalculoConversor {
      ConsultaApi consulta = new ConsultaApi();
      List<Conversiones> listaConversiones = new LinkedList<>();
    public String calculoConversor(String fechaActual, String moneda1, String moneda2, double valor) throws IOException  {
        Moneda moneda = consulta.optenerDatos(moneda1);
        double calculo = moneda.conversion_rates().get(moneda2) * valor;
        String resultado= " El valor " + valor + "" + "[" + moneda.base_code() + "] corresponde al valor final de " +
                           calculo+"["+moneda2+"]";
        Conversiones conversiones= new Conversiones(fechaActual,resultado);
        listaConversiones.add(conversiones);
        GenertadorDeArchivo generardor= new GenertadorDeArchivo();
        generardor.guardarJson(listaConversiones);
        return fechaActual + resultado;
      }
     public List<Conversiones> reporteConveriones() {
          return listaConversiones;
      }

}
