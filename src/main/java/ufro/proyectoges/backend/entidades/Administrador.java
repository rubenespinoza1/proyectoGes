/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades;

import ufro.proyectoges.backend.entidades.rut.Rut;
import ufro.proyectoges.backend.herramientas.HerramientaAdmin;

/**
 *
 * @author shido
 */
public class Administrador extends Persona {
    
    public Administrador(int id, String nombre, Rut rut, String clave) {
        super(id, nombre, rut, "ADMINISTRADOR", clave);
        super.setTipo_persona("ADMINISTRADOR");
        super.setHerramientaPersona(new HerramientaAdmin());
    }
    
}
