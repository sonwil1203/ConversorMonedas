package com.alura.conversormoneda;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Conversiones {
    private String fecha;
    private String conversion;

    public Conversiones(String fecha, String conversion) {
        this.fecha = fecha;
        this.conversion = conversion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }
}
