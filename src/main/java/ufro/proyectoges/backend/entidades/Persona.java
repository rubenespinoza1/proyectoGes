/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades;

import ufro.proyectoges.backend.entidades.rut.Rut;
import ufro.proyectoges.backend.herramientas.Herramienta;

/**
 * Esta clase contiene la estructura que se utilizara para definir tipos de persona que tendran acceso al sistema
 * @author shido
 */
public class Persona {

    protected String nombre;
    protected Rut rut;
    protected String tipo_persona;
    private String clave;
    protected Herramienta herramientaPersona;
    private int id;

    /**
     * Este es el Constructor de la clase Persona
     * @param nombre Este Parametro contiene el nombre de la persona
     * @param rut Este parametro contiene el rut de la persona
     * @param tipo_persona Este parametro contiene el tipo de persona
     * @param clave Este parametro contiene la clave de la persona
     */
    public Persona(int id,String nombre, Rut rut, String tipo_persona, String clave) {
        this.nombre = nombre;
        this.rut = rut;
        this.tipo_persona = tipo_persona;
        this.clave = clave;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    /**
     * Este metodo retorna el atributo Herramienta de esta clase
     * @return Retorna un objeto Herramienta
     */
    public Herramienta getHerramientaPersona() {
        return herramientaPersona;
    }

    /**
     * Este metodo edita el atributo herramientaPersona
     * @param herramientaPersona Este parametro reemplaza lo contenido en el atributo herramientaPersona
     */
    public void setHerramientaPersona(Herramienta herramientaPersona) {
        this.herramientaPersona = herramientaPersona;
    }

    /**
     * Este metodo retorna el atributo nombre
     * @return Retorna el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo retorna el rut de la persona
     * @return Retorna el rut, un objeto de clase Rut
     */
    public Rut getRut() {
        return rut;
    }

    /**
     * Este metodo retorna la clave de la persona
     * @return Retorna la clave, un valor tipo String
     */
    public String getClave() {
        return clave;
    }

    /**
     * Este metodo retorna el contenido del objeto de la clase Persona
     * @return Retorna un String que contiene los datos del objeto de la clase
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", rut=" + rut + ", tipo_persona=" + tipo_persona + ", clave=" + clave + ", herramientaPersona=" + herramientaPersona + '}';
    }

    /**
     * Este metodo retorna el tipo de persona
     * @return Retorna el tipo de persona, un valor tipo String
     */
    public String getTipo_persona() {
        return tipo_persona;
    }

    /**
     * Este metodo edita el tipo de persona
     * @param tipo_persona Este parametro reemplaza el tipo de persona
     */
    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

}
