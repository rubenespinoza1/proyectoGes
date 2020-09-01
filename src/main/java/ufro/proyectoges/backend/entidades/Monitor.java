/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades;

import ufro.proyectoges.backend.entidades.rut.Rut;
import ufro.proyectoges.backend.herramientas.HerramientaMonitor;

/**
 * Clase encargada de almacenar la entidad Monitor
 * @author shido
 */
public class Monitor extends Persona{
    /**
     * Constructor de la clase Monitor
     * @param nombre Este parametro contiene le nombre del monitor
     * @param rut Este parametro contiene el rut del monitor
     * @param clave Este parametro contiene la clave del monitor
     */
    public Monitor(int id,String nombre, Rut rut, String clave) {
        super(id,nombre, rut, "MONITOR", clave);
        super.setTipo_persona("MONITOR");
        super.setHerramientaPersona(new HerramientaMonitor());
    }
    
}
