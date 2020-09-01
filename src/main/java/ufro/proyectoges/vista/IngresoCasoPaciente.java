/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ufro.proyectoges.backend.entidades.IPDPaciente;
import ufro.proyectoges.backend.entidades.Monitor;
import ufro.proyectoges.backend.entidades.Paciente;
import ufro.proyectoges.backend.entidades.Persona;
import ufro.proyectoges.backend.entidades.Registrador;
import ufro.proyectoges.backend.entidades.rut.Rut;
import ufro.proyectoges.backend.herramientas.HerramientaRegistrador;

/**
 * Esta ventana gestiona el ingreso de los datos del paciente al sistema, o su
 * visualizacion
 *
 * @author Roald
 */
public class IngresoCasoPaciente extends javax.swing.JFrame implements KeyListener, ActionListener {

    private Persona personaOcupandoElPrograma;
    private IPDPaciente ipd;
    private List<String> patologias;
    private boolean soloVista;
    private Paciente pacienteAObservar;
    private BusquedaPaciente previous;
    private boolean editando;
    private int idOcupada;

    /**
     * Creates new form IngresoCasoPaciente Este metodo setea la forma para
     * cuando se va a ingresar a un paciente al sistema
     *
     * @param p Recibe un objeto de clase Persona, que hace alusion a la persona
     * usando el programa
     */
    public IngresoCasoPaciente(Persona p) {
        editando = false;
        this.personaOcupandoElPrograma = p;
        this.ipd = null;
        patologias = new ArrayList<>();
        initComponents();
        this.soloVista = false;
        this.PatologiasJTextField.setEditable(false);
        this.confirmacionIPD.setText("IPD no cargado");
        this.PatologiasJComboBox.setModel(new DefaultComboBoxModel<>(p.getHerramientaPersona().obtenerPatologias()));
        this.NombreJTextField.addKeyListener(this);
        this.RUTJTextField1.addKeyListener(this);
        this.RUTJTextField2.addKeyListener(this);
        this.PatologiasJComboBox.addActionListener(this);
        this.NombreFuncionarioJLabel.setText("");
        this.RUTFuncionarioJLabel.setText("");
        this.FechaJLabel.setText("");
        this.FechaIngresoJLabel.setText("");
        this.FuncionarioRegistroJLabel.setText("");

    }

    /**
     * Este metodo setea la forma para cuando se va a visualizar los datos de un
     * paciente que se haya buscado
     *
     * @param p Recibe un objeto de clase Persona, que hace alusion a la persona
     * usando el programa
     * @param previous Recibe los datos de la ventana BusquedaPaciente
     */
    public IngresoCasoPaciente(Paciente p, BusquedaPaciente previous) {

        initComponents();
        this.idOcupada = p.getIpdPaciente().getSecondary_key_paciente();
        this.personaOcupandoElPrograma = previous.getP();
        patologias = new ArrayList<>();
        this.ipd = p.getIpdPaciente();

        this.confirmacionIPD.setText(this.ipd != null ? "IPD Cargado" : "IPD No cargado");
        this.PatologiasJComboBox.setModel(new DefaultComboBoxModel<>(personaOcupandoElPrograma.getHerramientaPersona().obtenerPatologias()));

        ingresarPatologiasDelPaciente();

        this.NombreJTextField.addKeyListener(this);
        this.RUTJTextField1.addKeyListener(this);
        this.RUTJTextField2.addKeyListener(this);
        this.PatologiasJComboBox.addActionListener(this);

        if (personaOcupandoElPrograma instanceof Registrador) {
            editando = true;
            this.previous = previous;
            this.previous.setEnabled(false);
            
            this.pacienteAObservar = p;

            this.NombreJTextField.setText(p.getNombreCompleto());
            this.RUTJTextField1.setText(p.getRutValidado().substring(0, p.getRutValidado().length() - 1));
            this.RUTJTextField2.setText("" + p.getRutValidado().charAt(p.getRutValidado().length() - 1));
            this.PatologiasJTextField.setText(p.getIpdPaciente().getCodigoPatologia());

            Registrador registrador = previous.getP().getHerramientaPersona().obtenerRegistradorIPD(p.getIpdPaciente());

            this.NombreFuncionarioJLabel.setText(registrador.getNombre());
            this.RUTFuncionarioJLabel.setText(registrador.getRut().getRut());
            this.FechaJLabel.setText(p.getIpdPaciente().getFechaDeGuardado().toString());

            this.soloVista = false;

        } else if (personaOcupandoElPrograma instanceof Monitor) {
            this.previous = previous;
            this.limpPat.setEnabled(false);
            this.pacienteAObservar = p;
            
            this.confirmacionIPD.setText("IPD Confirmado");

            this.PatologiasJTextField.setEditable(false);
            this.NombreJTextField.setEditable(false);
            this.RUTJTextField1.setEditable(false);
            this.RUTJTextField2.setEditable(false);
            this.PatologiasJComboBox.setEnabled(false);

            this.NombreJTextField.setText(p.getNombreCompleto());
            this.RUTJTextField1.setText(p.getRutValidado().substring(0, p.getRutValidado().length() - 1));
            this.RUTJTextField2.setText("" + p.getRutValidado().charAt(p.getRutValidado().length() - 1));
            this.PatologiasJTextField.setText(p.getIpdPaciente().getCodigoPatologia());

            Registrador registrador = previous.getP().getHerramientaPersona().obtenerRegistradorIPD(p.getIpdPaciente());

            this.NombreFuncionarioJLabel.setText(registrador.getNombre());
            this.RUTFuncionarioJLabel.setText(registrador.getRut().getRut());
            this.FechaJLabel.setText(p.getIpdPaciente().getFechaDeGuardado().toString());
            this.IngresarJButton.setEnabled(false);
            this.soloVista = true;
        }

    }

    public boolean isEditando() {
        return editando;
    }

    private void ingresarPatologiasDelPaciente() {
        String patologia = "";

        String patologiasPrevias = ipd.getCodigoPatologia();

        patologiasPrevias = patologiasPrevias.replace("[", "");
        patologiasPrevias = patologiasPrevias.replace("]", "");

        if (patologiasPrevias.contains(",")) {

            for (int i = 0; i < patologiasPrevias.length(); i++) {
                if (!(patologiasPrevias.charAt(i) == ',')) {

                    patologia += patologiasPrevias.charAt(i);

                } else {

                    patologias.add(patologia);
                    patologia = "";
                    i++;

                }
            }

        } else {
            patologias.add(patologiasPrevias);
        }
    }

    /**
     * Retorna el el contenido del campo Nombre
     *
     * @return Retorna el contenido del JTextField Nombre
     */
    public JTextField getNombreJTextField() {
        return NombreJTextField;
    }

    /**
     * Retorna el contenido del campo Patologias
     *
     * @return Retorna el contenido del JTextField Patologias
     */
    public JTextField getPatologiasJTextField() {
        return PatologiasJTextField;
    }

    /**
     * Retorna el contenido del campo RUT
     *
     * @return Retorna el contenido del JTextField RUT
     */
    public JTextField getRUTJTextField1() {
        return RUTJTextField1;
    }

    /**
     * Retorna el contenido del campo RUT
     *
     * @return Retorna el contenido del JTextField RUT
     */
    public JTextField getRUTJTextField2() {
        return RUTJTextField2;
    }

    /**
     * Retorna el contenido del IPD del paciente
     *
     * @return Retorna un objeto de clase IPDPaciente, que contiene los datos
     * del IPD del paciente al que esta relacionado
     */
    public IPDPaciente getIpd() {
        return ipd;
    }

    /**
     * Este metodo edita el contenido del IPD del paciente
     *
     * @param ipd Este parametro edita el contenido del IPD del paciente
     */
    public void setIpd(IPDPaciente ipd) {
        this.ipd = ipd;
    }

    /**
     * Este metodo retorna la persona usando el sistema
     *
     * @return Retorna un objeto de clase Persona, aludiendo a la persona usando
     * el sistema
     */
    public Persona getP() {
        return personaOcupandoElPrograma;
    }

    /**
     * Este metodo edita el contenido de la Persona en el sistema
     *
     * @param p Recibe un objeto clase Persona que edita la Persona en el
     * sistema
     */
    public void setP(Persona p) {
        this.personaOcupandoElPrograma = p;
    }

    /**
     * Este metodo edita el label que indidica si hay un IPD para el paciente
     *
     * @return Retorna el JLabel indicandor de si existe el IPD
     */
    public JLabel getConfirmacionIPD() {
        return confirmacionIPD;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloJLabel = new javax.swing.JLabel();
        IngresoPacienteJLabel = new javax.swing.JLabel();
        NombreJLabel = new javax.swing.JLabel();
        NombreJTextField = new javax.swing.JTextField();
        RUTJLabel = new javax.swing.JLabel();
        RUTJTextField1 = new javax.swing.JTextField();
        RUTJTextField2 = new javax.swing.JTextField();
        PatologiasJLabel = new javax.swing.JLabel();
        PatologiasJTextField = new javax.swing.JTextField();
        PatologiasJComboBox = new javax.swing.JComboBox<>();
        IPDJButton = new javax.swing.JButton();
        FuncionarioRegistroJLabel = new javax.swing.JLabel();
        NombreFuncionarioJLabel = new javax.swing.JLabel();
        RUTFuncionarioJLabel = new javax.swing.JLabel();
        FechaIngresoJLabel = new javax.swing.JLabel();
        FechaJLabel = new javax.swing.JLabel();
        IngresarJButton = new javax.swing.JButton();
        VolverJButton = new javax.swing.JButton();
        confirmacionIPD = new javax.swing.JLabel();
        limpPat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ProyectoGES - Ingreso Caso Paciente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloJLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TituloJLabel.setText("GEST-ION");
        getContentPane().add(TituloJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 35, -1, -1));

        IngresoPacienteJLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        IngresoPacienteJLabel.setText("Ingreso Caso Paciente");
        getContentPane().add(IngresoPacienteJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 98, -1, -1));

        NombreJLabel.setText("Nombre Completo:");
        getContentPane().add(NombreJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 190, -1, -1));

        NombreJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreJTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(NombreJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 188, 394, -1));

        RUTJLabel.setText("RUT:");
        getContentPane().add(RUTJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 225, -1, -1));
        getContentPane().add(RUTJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 225, 78, -1));
        getContentPane().add(RUTJTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 225, 23, -1));

        PatologiasJLabel.setText("Patologias:");
        getContentPane().add(PatologiasJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 266, -1, -1));

        PatologiasJTextField.setToolTipText("Puede utilizar el desplegable para ingresar patologias");
        getContentPane().add(PatologiasJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 264, 296, -1));

        PatologiasJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patologia 1", "Patologia 2", "Patologia 3", "Patologia 4", "Patologia 5", "Patologia 6", "Patologia 7", "Patologia 8", "Patologia 9", "Patologia 10", "Patologia 11", "Patologia 12", "Patologia 13", "Patologia 14", "Patologia 15", "Patologia 16", "Patologia 17", "Patologia 18", "Patologia 19", "Patologia 20", "Patologia 21", "Patologia 22", "Patologia 23", "Patologia 24", "Patologia 25" }));
        PatologiasJComboBox.setToolTipText("Seleccione las patologia que desee ingresar");
        PatologiasJComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PatologiasJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                agregadorpatologia(evt);
            }
        });
        PatologiasJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatologiasJComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(PatologiasJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 176, -1));

        IPDJButton.setText("I.P.D.");
        IPDJButton.setToolTipText("Informe Proceso Diagnostico");
        IPDJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPDJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(IPDJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 334, -1, -1));

        FuncionarioRegistroJLabel.setText("Funcionario Registro:");
        getContentPane().add(FuncionarioRegistroJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 390, -1, -1));

        NombreFuncionarioJLabel.setText("Nombres Apellidos");
        getContentPane().add(NombreFuncionarioJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 415, -1, -1));

        RUTFuncionarioJLabel.setText("12.345.678-9");
        getContentPane().add(RUTFuncionarioJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 436, -1, -1));

        FechaIngresoJLabel.setText("Fecha Ingreso:");
        getContentPane().add(FechaIngresoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 390, -1, -1));

        FechaJLabel.setText("dd/mm/aaaa");
        getContentPane().add(FechaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 436, -1, -1));

        IngresarJButton.setText("Ingresar");
        IngresarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(IngresarJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 385, -1, -1));

        VolverJButton.setText("Volver");
        VolverJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VolverJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 385, -1, -1));

        confirmacionIPD.setText("TEXT");
        getContentPane().add(confirmacionIPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 339, -1, -1));

        limpPat.setText("Limpiar Campos Patologias");
        limpPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpPatActionPerformed(evt);
            }
        });
        getContentPane().add(limpPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreJTextFieldActionPerformed
    /**
     * Este metodo gestiona la apertura y muestra de datos en la ventana IPD del
     * paciente
     *
     * @param evt Este evento se genera cuando se hace click en el boton IPD
     */
    private void IPDJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPDJButtonActionPerformed
        // TODO add your handling code here:
        if (!soloVista) {
            if (Rut.rutBienEscrito(RUTJTextField1.getText() + RUTJTextField2.getText())) {
                Rut rut = new Rut(RUTJTextField1.getText() + RUTJTextField2.getText());
                if (!NombreJTextField.getText().isEmpty() && !RUTJTextField1.getText().isEmpty() && !RUTJTextField2.getText().isEmpty() && !this.PatologiasJTextField.getText().isEmpty() && Rut.rutBienEscrito(RUTJTextField1.getText() + RUTJTextField2.getText()) && rut.isRutValido()) {
                    new IPD(personaOcupandoElPrograma, this, pacienteAObservar).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Complete los datos de manera correcta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "el rut no esta bien escrito");
            }
        } else {
            this.setEnabled(false);
            new IPD(personaOcupandoElPrograma, this, pacienteAObservar).setVisible(true);
        }


    }//GEN-LAST:event_IPDJButtonActionPerformed
    /**
     * Este metodo gestiona el ingreso de los datos del paciente al sistema
     *
     * @param evt Este evento se genera cuando se hace click en el boton
     * Ingresar
     */
    private void IngresarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarJButtonActionPerformed
        // TODO add your handling code here:
        String rut = RUTJTextField1.getText() + RUTJTextField2.getText();

        if (!rut.isEmpty() && ipd != null && Rut.rutBienEscrito(rut)) {
            Rut rutValidado = new Rut(rut);

            if (rutValidado.isRutValido()) {
                int lastIdPaciente = editando ? idOcupada : personaOcupandoElPrograma.getHerramientaPersona().getLastIdPaciente() + 1;
                ipd.setSecondary_key_paciente(lastIdPaciente);
                Paciente pacienteAIngresar = new Paciente(lastIdPaciente, NombreJTextField.getText(), new Rut(RUTJTextField1.getText() + RUTJTextField2.getText()), ipd);
                if (!personaOcupandoElPrograma.getHerramientaPersona().personaExiste(pacienteAIngresar) && !editando) {
                    personaOcupandoElPrograma.getHerramientaPersona().registrarPacientes(pacienteAIngresar, (Registrador) personaOcupandoElPrograma);
                    new Menu(personaOcupandoElPrograma).setVisible(true);
                    
                    this.dispose();
                    
                } else if (editando) {
                    previous.setEnabled(true);
                    
                    for (int i = 0; i < previous.getModel().getRowCount(); i++) {
                       previous.getModel().removeRow(i); 
                    }
                    
                    previous.getPacientesObtenidos().clear();
                    personaOcupandoElPrograma.getHerramientaPersona().actualizarDatosPaciente(pacienteAIngresar, (Registrador) personaOcupandoElPrograma);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Rut ya registrado", "Error de validacion", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Rut invalido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo de rut vacio", "Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_IngresarJButtonActionPerformed
    /**
     * Este metodo permite volver al menu principal
     *
     * @param evt Este evento se genera cuando se hace click en el boton Volver
     */
    private void VolverJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverJButtonActionPerformed
        // TODO add your handling code here:
        if (!soloVista && !editando) {
            new Menu(personaOcupandoElPrograma).setVisible(true);
        } else if (!soloVista && editando) {

            this.previous.setEnabled(true);

        }

        this.dispose();
    }//GEN-LAST:event_VolverJButtonActionPerformed
    /**
     * Este metodo gestiona el agregado de patologias al campo de patologias
     * cuando se seleccionan desde el menu desplegable
     *
     * @param evt Este evento se genera cuando se selecciona un item del
     * combobox que contiene la lista de las patologias
     */
    private void agregadorpatologia(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_agregadorpatologia
        // TODO add your handling code here:

        if (!patologias.contains(PatologiasJComboBox.getItemAt(PatologiasJComboBox.getSelectedIndex()))) {
            patologias.add(PatologiasJComboBox.getItemAt(PatologiasJComboBox.getSelectedIndex()));
            PatologiasJTextField.setText(patologias.toString());
        }

    }//GEN-LAST:event_agregadorpatologia

    private void PatologiasJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatologiasJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatologiasJComboBoxActionPerformed

    private void limpPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpPatActionPerformed
        this.PatologiasJTextField.setText("");
        this.patologias.clear();
    }//GEN-LAST:event_limpPatActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FechaIngresoJLabel;
    private javax.swing.JLabel FechaJLabel;
    private javax.swing.JLabel FuncionarioRegistroJLabel;
    private javax.swing.JButton IPDJButton;
    private javax.swing.JButton IngresarJButton;
    private javax.swing.JLabel IngresoPacienteJLabel;
    private javax.swing.JLabel NombreFuncionarioJLabel;
    private javax.swing.JLabel NombreJLabel;
    private javax.swing.JTextField NombreJTextField;
    private javax.swing.JComboBox<String> PatologiasJComboBox;
    private javax.swing.JLabel PatologiasJLabel;
    private javax.swing.JTextField PatologiasJTextField;
    private javax.swing.JLabel RUTFuncionarioJLabel;
    private javax.swing.JLabel RUTJLabel;
    private javax.swing.JTextField RUTJTextField1;
    private javax.swing.JTextField RUTJTextField2;
    private javax.swing.JLabel TituloJLabel;
    private javax.swing.JButton VolverJButton;
    private javax.swing.JLabel confirmacionIPD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limpPat;
    // End of variables declaration//GEN-END:variables
    /**
     * Metodo no implementado
     *
     * @param e Recibe un evento que se genera al escribir una letra
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Metodo que gestiona el aviso de si existe un cambio en la existencia del
     * IPD
     *
     * @param e Recibe un evento que se genera al presionar una tecla
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (ipd != null) {
            advertirCambios();
        }
    }

    /**
     * Metodo no implementado
     *
     * @param e Recibe un evento que se genera al soltar una tecla
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Este metodo se encarga de avisar si existe una modificacion de datos para
     * rehacer el IPD
     */
    private void advertirCambios() {
        ipd = null;
        confirmacionIPD.setText("Datos modificados, se debe re-hacer ipd");
    }

    /**
     * Metodo que se encarga de avisar si existe un cambio de informacion de la
     * patologias para editar el IPD
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.PatologiasJComboBox && ipd != null) {
            advertirCambios();
        }
    }
}
