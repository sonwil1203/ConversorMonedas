/* Autoe:Wilson Omar Alfonso Contreras
   version v1.3
   Fecha 05/05/2024
   Conversor de monedaa  mediante consume de API https://www.exchangerate-api.com usando bibilioteca Gson
   Realiaza conversiones de 4 monedas a dolar y viseveresa.
   Realiza reporte de la converiones de moneda de fecha, hora y cambio realizado al finalizar la aplicaion
   Realiza reporte de la converiones en formtao json de  de fecha, hora y cambio realizado al finalizar la aplicaion
 */
package com.alura.conversormoneda;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class ConversorApp {
    public static void main(String[] args) throws IOException   {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatoFechaActual = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Scanner lecturaTeclado = new Scanner(System.in);
        String fechaActual = dateTime.format(formatoFechaActual);
        List<Conversiones> listaConversiones = new LinkedList<>();
        CalculoConversor resultado = new CalculoConversor();
        System.out.println("Sea Bienvenido al conversor de moneda");
        boolean salir= true;
        while (salir == true) {
            System.out.println("1) Dóllar ==> Peso colombiano");
            System.out.println("2) Peso colombiano ==> Dóllar ");
            System.out.println("3) Dóllar ==> Peso argentino");
            System.out.println("4) Peso Argentino ==> Dóllar ");
            System.out.println("5) Dóllar ==> Real brasileño");
            System.out.println("6) Peso Brasileño ==> Dóllar ");
            System.out.println("7) Dóllar ==> Peso Mexicano");
            System.out.println("8) Peso Mexicano ==> Dóllar ");
            System.out.println("9) Salir");
            System.out.println("Elija la opción valida ");
            System.out.println("*********************************************");
            int opcion = lecturaTeclado.nextInt();
            if(opcion == 9){
                salir=false;
                break;
            }
            System.out.println("Ingrese valor que deseas convertir:");
            double valor = lecturaTeclado.nextDouble();
            try {
                switch (opcion) {
                    case 1:
                        System.out.println(resultado.calculoConversor(fechaActual,"USD","COP",valor));
                        break;
                    case 2:
                        System.out.println(resultado.calculoConversor(fechaActual,"COP","USD",valor));
                        break;
                    case 3:
                        System.out.println(resultado.calculoConversor(fechaActual,"USD","ARS",valor));
                        break;
                    case 4:
                        System.out.println(resultado.calculoConversor(fechaActual,"ARS","USD",valor));
                        break;
                    case 5:
                        System.out.println(resultado.calculoConversor(fechaActual,"USD","BRL",valor));
                        break;
                    case 6:
                        System.out.println(resultado.calculoConversor(fechaActual,"BRL","USD",valor));
                        break;
                    case 7:
                        System.out.println(resultado.calculoConversor(fechaActual,"USD","MXN",valor));
                        break;
                    case 8:
                        System.out.println(resultado.calculoConversor(fechaActual,"MXN","USD",valor));
                        break;
                    default:
                        System.out.println("La opcion no es correcta");
                }
            System.out.println("*************************************************************************");
            } catch (NumberFormatException e) {
                System.out.println("Numero no encontrado " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Reporte de conversiones de monedas");
        listaConversiones=resultado.reporteConveriones();
        listaConversiones.forEach(item -> System.out.println(item.getFecha() + item.getConversion()));
        System.out.println("Finalizando la aplicaion");
    }

}
