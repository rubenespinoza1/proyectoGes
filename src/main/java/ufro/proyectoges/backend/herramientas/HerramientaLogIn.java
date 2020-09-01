/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.herramientas;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import ufro.proyectoges.backend.entidades.IPDPaciente;
import ufro.proyectoges.backend.entidades.Monitor;
import ufro.proyectoges.backend.entidades.Paciente;
import ufro.proyectoges.backend.entidades.Persona;
import ufro.proyectoges.backend.entidades.Registrador;
import ufro.proyectoges.backend.entidades.rut.Rut;
import static ufro.proyectoges.backend.herramientas.Herramienta.handler;
/**
 * Clase que se encarga de manejar los metodos para el Login del Programa
 * @author Roald
 */
public class HerramientaLogIn implements Herramienta {
/**
 * Constructor de la clase HerramientaLogin
 */
    public HerramientaLogIn() {

    }
/**
 * Este metodo se venia con la implementacion de la interfaz Herramienta, intentar usarlo muestra un mensaje de error
 * @param inicio Recibe una variable de tipo Date que hace alucion a la fecha de incio de la atencion del paciente
 * @param termino Recibe una variable de ipo Date que hace alucion a la fecha de termino de la atencion del paciente
 * @return retorna un boolean con el valor de falso
 */
    @Override
    public boolean descargarBasesDeDatos(Date inicio, Date termino) {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
        return false;
    }
/**
 * Metodo que venia con la implementacion de la interfaz Herramienta, usarlo muestra un mensaje de error
 * @param nombre Recibe un String que contiene el nombre del paciente
 * @return Retorna un objeto de clase Paciente, en esta implementacion solo se envia un objeto nulo
 */
    @Override
    public Paciente buscarPacientePorNombre(String nombre) {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
        return null;
    }
/**
 * Metodo que venia con la implementacion de la interfaz Herramienta, usarlo muestra un mensaje de error
 * @param rut Recibe un objeto de clase Rut, objeto que maneja las operaciones que se hacen con un rut del paciente
 * @return Se espera que retorne un objeto de la clase Paciente, sin embargo esta implementacion solo retorna null
 */
    @Override
    public Paciente buscarPacientePorRut(Rut rut) {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
        return null;
    }
/**
 * Metodo que venia en la implementacion de la interfaz Herramienta, usarlo muestra un mensaje de error
 * @param p Recibe un objeto de clase Persona, haciendo alusion a alguna persona que se pretende verificar
 * @return Debiera retornar si existe la persona o no, sin embargo aqui solo retorna falso, ya que no se pretende usar el metodo desde esta clase
 */
    @Override
    public boolean personaExiste(Persona p) {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
        return false;
    }
/**
 * Metodo que viene con la implementacion de Herramienta, aqui se utiliza para buscar una persona en concreto
 * @param rut recibe un obejto de clase Rut, el cual contiene el rut de la persona que se pretende verificar
 * @return Retorna un objeto de clase Persona que contiene los datos de la persona buscada
 */
    @Override
    public Persona buscarPersona(Rut rut) {
        try {
            ResultSet queryResult = handler.selectFromWhere("*", "personas", "id", rut.getRut());
            while (queryResult.next()) {
                return new Persona(queryResult.getInt(5),queryResult.getString(2), new Rut(queryResult.getString(1)), queryResult.getString(3), queryResult.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
/**
 * Metodo que venia en la implementacion de la interfaz Herramienta, usarlo muestra un mensaje de error
 * @return Se esperaria que retorne una lista de pacientes, sin embargo solo retornara null
 */
    @Override
    public List<Paciente> obtenerPacientes() {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
        return null;
    }
/**
 * Metodo que venia en la implementacion de la interfaz Herramienta, usarlo solo muestra un mensaje de error
 * @param r Recibe un objeto del tipo monitor, que hace al monitor que se pretendia registrar
 */
    @Override
    public void registrarMonitor(Monitor r) {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
    }
/**
 * Metodo que venia en la implementacion de la interfaz Herramienta, usarlo solo muestra un mensaje de error
 * @param r Recibe un objeto de clase Registrador, que hace alucion al registrador que se pretendia registrar
 */
    @Override
    public void registrarRegistrador(Registrador r) {
        JOptionPane.showMessageDialog(null, "Permisos insuficientes");
    }

    
/**
 * Metodo que venia en la implementacion de la interfaz Herramienta, en este caso no hace nada
 * @param id Recibe un entero, que hace alucion al id del IPD
 * @return Debiera retornar un objeto de clase IPDPaciente, aqui no retorna nada
 */
    @Override
    public IPDPaciente buscarIPDporRut(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Metodo que venia en la implementacion de la interfaz Herramienta, en este caso no hace nada
 * @return Debiera retornar un arreglo de String, sin embargo aqui no retorna nada
 */
    @Override
    public String[] obtenerPatologias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Metodo que venia con la implementacion de la interfaz Herramienta, en este caso no hace nada
 * @param nombre Recibe una variable de tipo String, que hacia alusion al nombre de la patologia
 * @return Debiera retornar un entero, sin embargo aqui no retorna nada
 */
    @Override
    public int consultarIDPatologiaPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Metodo que venia con la implementacion de la interfaz Herramienta, aqui no hace nada
 * @param paciente Recibe un objeto de la clase Paciente
 * @param registrador Recibe un objeto de la clase Registrador
 */
    @Override
    public void registrarPacientes(Paciente paciente, Registrador registrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Metodo que venia con la implementacion de la interfaz Herramienta, aqui no hace nada
 * @param ipd Recibe un objeto de clase IPDPaciente
 * @param registrador Recibe un objeto de clase Registrador
 */
    @Override
    public void registrarIPD(IPDPaciente ipd, Registrador registrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Metodo que venia con la implementacion de la interfaz Herramienta, aqui no hace nada
 * @param ipd Recibe un objeto de la clase IPDPaciente
 * @return Debiera retornar un objeto de clase Registrador, aqui no retorna nada
 */
    @Override
    public Registrador obtenerRegistradorIPD(IPDPaciente ipd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarDatosPaciente(Paciente paciente, Registrador registrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarDatosIpd(IPDPaciente ipd, Registrador registrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastIdPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSecIdByRut(Rut rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
