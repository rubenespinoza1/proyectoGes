/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades;

import ufro.proyectoges.backend.entidades.rut.Rut;
import ufro.proyectoges.backend.herramientas.HerramientaRegistrador;

/**
 * Esta clase contiene la informacion del Registrador
 * @author shido
 */
public class Registrador extends Persona {

    /**
     * Constructor de la clase Registrador
     * @param nombre Este parametro es el nombre del registrador
     * @param rut Este parametro es el rut del registrador
     * @param clave Este parametro es la clave del registrador
     */
    public Registrador(int id,String nombre, Rut rut, String clave) {
        super(id,nombre, rut, "REGISTRADOR", clave);
        super.setTipo_persona("REGISTRADOR");
        super.setHerramientaPersona(new HerramientaRegistrador());
    }

}
