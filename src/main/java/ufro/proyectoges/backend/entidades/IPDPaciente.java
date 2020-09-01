/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades;

import java.sql.Date;
import java.util.List;

/**
 * Clase encargada de almacenar los datos de la Entidad IPD del Paciente
 * @author Roald
 */
public class IPDPaciente {

    private String rutPaciente;
    private String nombrePaciente;
    private Date fechaInicio;
    private Date fechaTermino;
    private boolean esGes;
    private boolean notificacionPacienteGES;
    private boolean confirmado;
    private boolean exceptuado;
    private boolean descartado;
    private String observacion;
    private String codigoPatologia;
    private String idRegistrador;
    private Date fechaDeGuardado;
    private int secondary_key_paciente;

    /**
     * Constructor de la clase IPDPaciente, sin parametros
     */
    public IPDPaciente() {
    }

    /**
     * Constructor de la clase IPDPaciente
     * @param rutPaciente Este parametro contiene el rut del paciente
     * @param nombrePaciente Este parametro contiene el nombre del paciente
     * @param fechaInicio Este parametro contiene la fecha de inicio del caso
     * @param fechaTermino Este parametro contiene la fecha de termino del caso
     * @param esGes Este parametro inidica si el paciente es o no ges
     * @param notificacionPacienteGES Este parametro inidica si el paciente fue notificado
     * @param confirmado Este paramentro indica si el paciente fue confirmado su diagnostico
     * @param descartado Este parametro indica si el paciente fue descartado su diagnostico
     * @param exceptuado Este parametro indica si se le considera exceptuada la atencion al paciente
     * @param observacion Este parametro contiene la observacion del medico que lo examino
     * @param codPatologias Este parametro contiene los codigos de las patologias
     * @param idRegistrador Este parametro contiene el id del registrador
     * @param fechaDeGuardado Este parametro contiene la fecha de ingreso
     */
    public IPDPaciente(String rutPaciente, String nombrePaciente, Date fechaInicio, Date fechaTermino, boolean esGes, boolean notificacionPacienteGES, boolean confirmado, boolean descartado, boolean exceptuado, String observacion, String codPatologias, String idRegistrador, Date fechaDeGuardado, int sec_id_paciente) {
        this.rutPaciente = rutPaciente;
        this.nombrePaciente = nombrePaciente;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.esGes = esGes;
        this.notificacionPacienteGES = notificacionPacienteGES;
        this.confirmado = confirmado;
        this.exceptuado = exceptuado;
        this.observacion = observacion;
        this.descartado = descartado;
        this.codigoPatologia = codPatologias;
        this.idRegistrador = idRegistrador;
        this.fechaDeGuardado = fechaDeGuardado;
        this.secondary_key_paciente = sec_id_paciente;
    }

    public int getSecondary_key_paciente() {
        return secondary_key_paciente;
    }

    public void setSecondary_key_paciente(int secondary_key_paciente) {
        this.secondary_key_paciente = secondary_key_paciente;
    }
    
    

    /**
     * Este metodo retorna la fecha de ingreso
     * @return Retorna un valor de tipo Date que contiene la fecha de ingreso
     */
    public Date getFechaDeGuardado() {
        return fechaDeGuardado;
    }

    /**
     * Este metodo retorna el id del registrador
     * @return Retorna un valor String que contiene el ID del registrador
     */
    public String getIdRegistrador() {
        return idRegistrador;
    }

    /**
     * Este metodo sirve para editar el atributo que almacena el id del registrador
     * @param idRegistrador Este parametro se utiliza para editar el atributo que almacena el id del registrador
     */
    public void setIdRegistrador(String idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    /**
     * Este metodo retorna el atributo que contiene el codigo de las patologias
     * @return Retorna un valor String que contiene el codigo de las patologias
     */
    public String getCodigoPatologia() {
        return codigoPatologia;
    }

    /**
     * Este metodo retorna el atributo que contiene el rut del paciente
     * @return Retorna un valor String que contiene el rut del paciente
     */
    public String getRutPaciente() {
        return rutPaciente;
    }

    /**
     * Este metodo edita el atributo que contiene el rut del paciente
     * @param rutPaciente Este parametro se utiliza para editar el atributo que contiene el rut del paciente
     */
    public void setRutPaciente(String rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    /**
     * Este metodo retorna el atributo que contiene el nombre del paciente
     * @return Retorna un valor String que contiene el nombre del paciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Este metodo edita el atributo que contiene el nombre del paciente
     * @param nombrePaciente Este parametro sirve para editar el atributo que contiene el nombre del paciente
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * Este metodo retorna el atributo que contiene la fecha de ingreso del caso del paciente
     * @return Retorna un valor tipo Date que contiene la fecha de ingreso del caso del paciente
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Este metodo retorna el atributo que contiene el estado de descartado del diagnostico del paciente
     * @return Retorna un valor de tipo boolean que contiene el estado de descartado del diagnostico del paciente
     */
    public boolean isDescartado() {
        return descartado;
    }

    /**
     * Este metodo edita el atributo qe contiene la fecha de termino del caso del paciente
     * @param fechaInicio Este parametro sirve para editar el valor de la fecha de termino del caso del paciente
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Este metodo retorna el atributo que contiene la fecha de termino del caso del paciente
     * @return Retorna un valor de tipo Date que contiene la fecha del termino de caso del paciente
     */
    public Date getFechaTermino() {
        return fechaTermino;
    }

    /**
     * Este metodo edita el atributo que contiene la fecha de termino del caso del paciente
     * @param fechaTermino Este parametro sirve para editar la fecha de termino del caso del paciente
     */
    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    /**
     * Este metodo retorna el atributo quue contiene si el paciente es ges
     * @return Retorna un valor de tipo boolean que contiene si el paciente es ges
     */
    public boolean isEsGes() {
        return esGes;
    }

    /**
     * Este metodo edita el atributo que contiene si el paciente es ges
     * @param esGes Este parametro sirve para editar el atributo que indica si el paciente es ges
     */
    public void setEsGes(boolean esGes) {
        this.esGes = esGes;
    }

    /**
     * Este metodo retorna el atributo que indica si el paciente fue notificado
     * @return Retorna un valor de tipo boolean que indica si el paciente fue notificado
     */
    public boolean isNotificacionPacienteGES() {
        return notificacionPacienteGES;
    }

    /**
     * Este metodo edita el atributo que indica si el paciente fue notificado
     * @param notificacionPacienteGES Este parametro sirve para editar el atributo que indica si el paciente fue notificado
     */
    public void setNotificacionPacienteGES(boolean notificacionPacienteGES) {
        this.notificacionPacienteGES = notificacionPacienteGES;
    }

    /**
     * Este metodo retorna el atributo que indica si el diagnostico del paciente esta confirmado
     * @return Retorna un valor de tipo boolean que indica si el diagnostico del paciente esta confirmado
     */
    public boolean isConfirmado() {
        return confirmado;
    }

    /**
     * Este metodo edita el atributo que indica si el diagnostico del paciente esta confirmado
     * @param confirmado Este parametro edita el atributo que indica si el diagnostico del paciente esta confirmado
     */
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    /**
     * Este metodo retorna el atributo que contiene si la atencion del paciente esta exceptuada
     * @return Retorna un valor de tipo boolean que contiene si la atencion de paciente esta exceptuada
     */
    public boolean isExceptuado() {
        return exceptuado;
    }

    /**
     * Este metodo edita el atributo que contiene si la atencion del paciente esta exceptuada
     * @param exceptuado Este parametro edita el atributo que contiene si la atencion del paciente esta excpetuada
     */
    public void setExceptuado(boolean exceptuado) {
        this.exceptuado = exceptuado;
    }

    /**
     * Este metodo retorna el atributo que contiene la observacion hecha por el medico que atendio al paciente
     * @return Retorna un valor de tipo String, que contien la observacion hecha por el medico que atendio al paciente
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Este metodo edita el atributo que contiene la observacion hecha por el medico que atendio al paciente
     * @param observacion Este parametro edita el atributo que contiene la observacion hecha por el medico que atendio al paciente
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "IPDPaciente{" + "rutPaciente=" + rutPaciente + ", nombrePaciente=" + nombrePaciente + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", esGes=" + esGes + ", notificacionPacienteGES=" + notificacionPacienteGES + ", confirmado=" + confirmado + ", exceptuado=" + exceptuado + ", descartado=" + descartado + ", observacion=" + observacion + ", codigoPatologia=" + codigoPatologia + ", idRegistrador=" + idRegistrador + ", fechaDeGuardado=" + fechaDeGuardado + '}';
    }
    
    

}
