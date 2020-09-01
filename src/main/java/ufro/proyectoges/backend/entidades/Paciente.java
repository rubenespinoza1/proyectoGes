/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades;

import ufro.proyectoges.backend.entidades.rut.Rut;

/**
 * Esta clase esta encargada de almacenar los datos de la entidad Paciente
 * @author shido
 */
public class Paciente extends Persona {

    private String nombreCompleto;
    private String rutValidado;
    private Rut rutSinConvertir;
    private IPDPaciente ipdPaciente;
    private int ipdId;
    private int id;

    /**
     * Constructor de la clase Paciente
     * @param nombreCompleto Este parametro contiene el nombre completo del paciente
     * @param rut Este parametro contiene el rut del paciente
     * @param ipd Este parametro contiene el ipd del paciente
     */
    public Paciente(int id,String nombreCompleto, Rut rut, IPDPaciente ipd) {
        super(id,nombreCompleto, rut, "PACIENTE", null);
        super.setTipo_persona("PACIENTE");
        super.setHerramientaPersona(null);
        this.nombreCompleto = nombreCompleto;
        this.rutSinConvertir = rut;
        this.rutValidado = rut.getRut();
        this.ipdPaciente = ipd;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    

    /**
     * Este metodo retorna el atributo que contiene el rut del paciente, sin convertir en otro formato
     * @return Retorna un objeto de la clase Rut, que posee el rut del paciente, sin convertir en otro formato
     */
    public Rut getRutSinConvertir() {
        return rutSinConvertir;
    }

    /**
     * Este metodo retorna el atributo que contiene el nombe completo del paciente
     * @return Retorna un valor de tipo String, que contiene el nombre completo del paciente
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Este metodo retorna el atributo que contiene el rut del paciente validado
     * @return Retorna un valor de tipo String, que posee el rut del paciente validado
     */
    public String getRutValidado() {
        return rutValidado;
    }

    /**
     * Este metodo retorna el atributo que contiene el IPD del paciente
     * @return Retorna un objeto de tipo IPDPaciente, que contiene el IPD del paciente
     */
    public IPDPaciente getIpdPaciente() {
        return ipdPaciente;
    }

    /**
     * Este metodo edita el atributo que contiene IPD del paciente
     * @param ipdPaciente Este parametro edita el atributo que contiene el IPD del paciente
     */
    public void setIpdPaciente(IPDPaciente ipdPaciente) {
        this.ipdPaciente = ipdPaciente;
    }

    /**
     * Este metodo retorna los contenidos del Objeto que haya sido creado de esta clase
     * @return Retorna un valor de tipo String, que posee el contenido del objeto que haya sido creado de esta clase
     */
    @Override
    public String toString() {
        return "Paciente{" + "nombreCompleto=" + nombreCompleto + ", rutValidado=" + rutValidado + ", Null ipd?=" + (ipdPaciente == null) + '}';
    }

}
