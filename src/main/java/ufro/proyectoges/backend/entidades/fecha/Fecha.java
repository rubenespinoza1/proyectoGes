/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades.fecha;

import java.sql.Date;

/**
 * Esta clase sirve para manejar las fechas
 * @author shido
 */
public class Fecha {

    /**
     * Este metodo retorna el año de una fecha
     * @param date Este parametro entrega la fecha
     * @return Retorna el año , mediante un String
     */
    public static String getYear(Date date) {
        if (date != null) {
            String fecha = date.toString();
            return "" + fecha.charAt(0) + fecha.charAt(1) + fecha.charAt(2) + fecha.charAt(3);
        }
        return "";
    }

    /**
     * Este metodo retorna el mes de una fecha
     * @param date Este parametro entrega la fecha
     * @return Retorna el mes, mediante un String
     */
    public static String getMonth(Date date) {
        if (date != null) {
            String fecha = date.toString();
            return "" + fecha.charAt(5) + fecha.charAt(6);
        }
        return "";
    }

    /**
     * Este metodo Retorna el dia de una fecha
     * @param date Este parametro entrega la fecha
     * @return Retorna el dia, Mediante un String
     */
    public static String getDay(Date date) {
        if (date != null) {
            String fecha = date.toString();
            return "" + fecha.charAt(8) + fecha.charAt(9);
        }
        return "";
    }

    /**
     * Este metodo compara si la primera fecha es menor que las segunda fecha
     * @param fecha1 Este parametro entrega la primera fecha
     * @param fecha2 Este parametro entrega la segunda fecha
     * @return Retorna la primera fecha es menor, mediante un boolean
     */
    public static boolean fecha1MenorQueFecha2(Date fecha1, Date fecha2) {
        if (fecha2 == null) {
            return true;
        }
        return fecha1.compareTo(fecha2) < 0;
    }
}
