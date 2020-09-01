/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.vista;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JOptionPane;
import ufro.proyectoges.backend.entidades.IPDPaciente;
import ufro.proyectoges.backend.entidades.Monitor;
import ufro.proyectoges.backend.entidades.Paciente;
import ufro.proyectoges.backend.entidades.Persona;
import ufro.proyectoges.backend.entidades.Registrador;
import ufro.proyectoges.backend.entidades.fecha.Fecha;
import ufro.proyectoges.backend.entidades.rut.Rut;
import ufro.proyectoges.backend.herramientas.HerramientaRegistrador;

/**
 * Esta ventana gestiona el IPD del paciente al que esta relacionado
 *
 * @author Roald
 */
public class IPD extends javax.swing.JFrame {

    private IngresoCasoPaciente formPaciente;
    private IngresoCasoPaciente previous;
    private Persona p;

    /**
     * Creates new form IPD Este metodo setea la forma para ingresar el ipd del
     * paciente a la base de datos
     *
     * @param p Recibe un objeto clase Persona que contiene los datos de la
     * persona que usa el sistema
     * @param formPaciente Recibe los datos de la ventana IngresoCasoPaciente
     */
    public IPD(Persona p, IngresoCasoPaciente formPaciente, Paciente paciente) {
        
        initComponents();
        if (p instanceof Registrador) {
            this.formPaciente = formPaciente;
            this.p = p;

            NombreCompletoJTextField.setEditable(false);
            RUTJTextField1.setEditable(false);
            RUTJTextField2.setEditable(false);
            PatologiasJTextField.setEditable(false);

            if (paciente == null) {
                
                NombreCompletoJTextField.setText(formPaciente.getNombreJTextField().getText());
                RUTJTextField1.setText(formPaciente.getRUTJTextField1().getText());
                RUTJTextField2.setText(formPaciente.getRUTJTextField2().getText());
                PatologiasJTextField.setText(formPaciente.getPatologiasJTextField().getText());

            } else {
                IPDPaciente ipd = paciente.getIpdPaciente();
                NombreCompletoJTextField.setText(formPaciente.getNombreJTextField().getText());
                RUTJTextField1.setText(formPaciente.getRUTJTextField1().getText());
                RUTJTextField2.setText(formPaciente.getRUTJTextField2().getText());
                PatologiasJTextField.setText(formPaciente.getPatologiasJTextField().getText());

                

                AnioFechaInicioJTextField.setText(Fecha.getYear(ipd.getFechaInicio()));
                MesFechaInicioJTextField.setText(Fecha.getMonth(ipd.getFechaInicio()));
                DiaFechaInicioJTextField.setText(Fecha.getDay(ipd.getFechaInicio()));

                AnioFechaTerminoJTextField.setText(Fecha.getYear(ipd.getFechaTermino()));
                MesFechaTerminoJTextField.setText(Fecha.getMonth(ipd.getFechaTermino()));
                DiaFechaTerminoJTextField.setText(Fecha.getDay(ipd.getFechaTermino()));
                NoGesJCheckBox.setSelected(!ipd.isEsGes());
                SiJCheckBox.setSelected(ipd.isNotificacionPacienteGES());
                NoJCheckBox.setSelected(!ipd.isNotificacionPacienteGES());
                ConfirmadoJCheckBox.setSelected(ipd.isConfirmado());
                GESJCheckBox.setSelected(ipd.isEsGes());

                ExceptuadoJCheckBox.setSelected(ipd.isExceptuado());
                ConfirmadoJCheckBox.setSelected(ipd.isConfirmado());
                DescartadoJCheckBox.setSelected(ipd.isDescartado());

                ObservacionJTextArea.setText(ipd.getObservacion());
            }

        } else if (p instanceof Monitor) {
            this.previous = formPaciente;
            IPDPaciente ipd = paciente.getIpdPaciente();
            NombreCompletoJTextField.setEditable(false);
            RUTJTextField1.setEditable(false);
            RUTJTextField2.setEditable(false);
            PatologiasJTextField.setEditable(false);
            AnioFechaInicioJTextField.setEditable(false);
            MesFechaInicioJTextField.setEditable(false);
            DiaFechaInicioJTextField.setEditable(false);
            AnioFechaTerminoJTextField.setEditable(false);
            MesFechaTerminoJTextField.setEditable(false);
            DiaFechaTerminoJTextField.setEditable(false);
            GESJCheckBox.setEnabled(false);
            ExceptuadoJCheckBox.setEnabled(false);
            ConfirmadoJCheckBox.setEnabled(false);
            DescartadoJCheckBox.setEnabled(false);
            ObservacionJTextArea.setEditable(false);

            SiJCheckBox.setEnabled(false);
            NoJCheckBox.setEnabled(false);
            ConfirmadoJCheckBox.setEnabled(false);
            NoGesJCheckBox.setEnabled(false);

            NombreCompletoJTextField.setText(ipd.getNombrePaciente());
            RUTJTextField1.setText(ipd.getRutPaciente().substring(0, ipd.getRutPaciente().length() - 1));
            RUTJTextField2.setText("" + ipd.getRutPaciente().charAt(ipd.getRutPaciente().length() - 1));
            PatologiasJTextField.setText(ipd.getCodigoPatologia());

            AnioFechaInicioJTextField.setText(Fecha.getYear(ipd.getFechaInicio()));
            MesFechaInicioJTextField.setText(Fecha.getMonth(ipd.getFechaInicio()));
            DiaFechaInicioJTextField.setText(Fecha.getDay(ipd.getFechaInicio()));

            AnioFechaTerminoJTextField.setText(Fecha.getYear(ipd.getFechaTermino()));
            MesFechaTerminoJTextField.setText(Fecha.getMonth(ipd.getFechaTermino()));
            DiaFechaTerminoJTextField.setText(Fecha.getDay(ipd.getFechaTermino()));
            NoGesJCheckBox.setSelected(!ipd.isEsGes());
            SiJCheckBox.setSelected(ipd.isNotificacionPacienteGES());
            NoJCheckBox.setSelected(!ipd.isNotificacionPacienteGES());
            ConfirmadoJCheckBox.setSelected(ipd.isConfirmado());
            GESJCheckBox.setSelected(ipd.isEsGes());

            ExceptuadoJCheckBox.setSelected(ipd.isExceptuado());
            ConfirmadoJCheckBox.setSelected(ipd.isConfirmado());
            DescartadoJCheckBox.setSelected(ipd.isDescartado());

            ObservacionJTextArea.setText(ipd.getObservacion());

            AceptarJButton.setEnabled(false);
            VolverJButton.setEnabled(true);
        }

    }

    /**
     * Creates new form IPD Este metodo setea la forma de la ventana para cuando
     * se hace la busqueda de paciente
     *
     * @param paciente Recibe un objeto de clase Paciente, que contiene los
     * datos del paciente que ha sido buscado
     * @param previous Recibe los datos de la ventana IngresoCasoPaciente, que
     * posee los datos del paciente
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IPDJLabel = new javax.swing.JLabel();
        NombreCompletoJLabel = new javax.swing.JLabel();
        NombreCompletoJTextField = new javax.swing.JTextField();
        RUTJLabel = new javax.swing.JLabel();
        RUTJTextField1 = new javax.swing.JTextField();
        RUTJTextField2 = new javax.swing.JTextField();
        PatologiasJLabel = new javax.swing.JLabel();
        PatologiasJTextField = new javax.swing.JTextField();
        FechaInicioJLabel = new javax.swing.JLabel();
        DiaFechaInicioJTextField = new javax.swing.JTextField();
        MesFechaInicioJTextField = new javax.swing.JTextField();
        AnioFechaInicioJTextField = new javax.swing.JTextField();
        FechaTerminoJLabel = new javax.swing.JLabel();
        DiaFechaTerminoJTextField = new javax.swing.JTextField();
        MesFechaTerminoJTextField = new javax.swing.JTextField();
        AnioFechaTerminoJTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        GESJCheckBox = new javax.swing.JCheckBox();
        NoGesJCheckBox = new javax.swing.JCheckBox();
        NotificacionPacienteGesJLabel = new javax.swing.JLabel();
        SiJCheckBox = new javax.swing.JCheckBox();
        NoJCheckBox = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        ConfirmadoJCheckBox = new javax.swing.JCheckBox();
        DescartadoJCheckBox = new javax.swing.JCheckBox();
        ExceptuadoJCheckBox = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        ObservacionJLabel = new javax.swing.JLabel();
        ObservacionJScrollPane = new javax.swing.JScrollPane();
        ObservacionJTextArea = new javax.swing.JTextArea();
        AceptarJButton = new javax.swing.JButton();
        VolverJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ProyectoGES - IPD");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IPDJLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        IPDJLabel.setText("IPD");
        getContentPane().add(IPDJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 12, -1, -1));

        NombreCompletoJLabel.setText("Nombre Completo:");
        getContentPane().add(NombreCompletoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 84, -1, -1));
        getContentPane().add(NombreCompletoJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 233, -1));

        RUTJLabel.setText("RUT");
        getContentPane().add(RUTJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 115, -1, -1));
        getContentPane().add(RUTJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 96, -1));
        getContentPane().add(RUTJTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 28, -1));

        PatologiasJLabel.setText("Patologias:");
        getContentPane().add(PatologiasJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 152, -1, -1));
        getContentPane().add(PatologiasJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 150, 268, -1));

        FechaInicioJLabel.setText("Fecha de Inicio");
        getContentPane().add(FechaInicioJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 84, -1, -1));
        getContentPane().add(DiaFechaInicioJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 101, 30, -1));
        getContentPane().add(MesFechaInicioJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 101, 29, -1));
        getContentPane().add(AnioFechaInicioJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 101, 59, -1));

        FechaTerminoJLabel.setText("Fecha de Termino");
        getContentPane().add(FechaTerminoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 132, -1, -1));
        getContentPane().add(DiaFechaTerminoJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 150, 30, -1));
        getContentPane().add(MesFechaTerminoJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 29, -1));
        getContentPane().add(AnioFechaTerminoJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 150, 59, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 187, 607, 10));

        GESJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        GESJCheckBox.setText("GEST");
        GESJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GESJCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(GESJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 203, -1, -1));

        NoGesJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NoGesJCheckBox.setText("NO GEST");
        NoGesJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoGesJCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(NoGesJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 248, -1, -1));

        NotificacionPacienteGesJLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NotificacionPacienteGesJLabel.setText("Notificacion Paciente Gest");
        getContentPane().add(NotificacionPacienteGesJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, -1, -1));

        SiJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SiJCheckBox.setText("SI");
        SiJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiJCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(SiJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 248, -1, -1));

        NoJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NoJCheckBox.setText("NO");
        NoJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoJCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(NoJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 248, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 282, 607, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 50, 607, 12));

        ConfirmadoJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ConfirmadoJCheckBox.setText("Confirmado");
        ConfirmadoJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmadoJCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ConfirmadoJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 300, -1, -1));

        DescartadoJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DescartadoJCheckBox.setText("Descartado");
        DescartadoJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescartadoJCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DescartadoJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 330, -1, -1));

        ExceptuadoJCheckBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ExceptuadoJCheckBox.setText("Exceptuado");
        getContentPane().add(ExceptuadoJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 300, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 364, 607, 10));

        ObservacionJLabel.setText("Observacion:");
        getContentPane().add(ObservacionJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 380, -1, -1));

        ObservacionJTextArea.setColumns(20);
        ObservacionJTextArea.setRows(5);
        ObservacionJScrollPane.setViewportView(ObservacionJTextArea);

        getContentPane().add(ObservacionJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 401, 585, 98));

        AceptarJButton.setText("Aceptar");
        AceptarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AceptarJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 505, -1, -1));

        VolverJButton.setText("Volver");
        VolverJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VolverJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 505, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/med2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Este metodo ingresa los datos del IPD del paciente al que va relacionado
     * en la base de datos
     *
     * @param evt Este evento se genera cuando se hace click en el boton Aceptar
     */
    private void AceptarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarJButtonActionPerformed
        // TODO add your handling code here:

        boolean nomNoVacio = !NombreCompletoJTextField.getText().isEmpty();
        boolean rutNoVacio = !RUTJTextField1.getText().isEmpty() && !RUTJTextField2.getText().isEmpty();
        boolean fechaInNoVac = !AnioFechaInicioJTextField.getText().isEmpty() && !MesFechaInicioJTextField.getText().isEmpty() && !DiaFechaInicioJTextField.getText().isEmpty();

        boolean gesONoGES = GESJCheckBox.isSelected();
        boolean notif = SiJCheckBox.isSelected() || NoJCheckBox.isSelected();
        boolean ConExDes = ConfirmadoJCheckBox.isSelected() || ExceptuadoJCheckBox.isSelected() || DescartadoJCheckBox.isSelected();
        boolean obser = !ObservacionJTextArea.getText().isEmpty();

        Date fecha_termin;

        if (AnioFechaTerminoJTextField.getText().isEmpty() || MesFechaTerminoJTextField.getText().isEmpty() || DiaFechaTerminoJTextField.getText().isEmpty()) {
            fecha_termin = null;
        } else {
            fecha_termin = Date.valueOf(AnioFechaTerminoJTextField.getText() + "-" + MesFechaTerminoJTextField.getText() + "-" + DiaFechaTerminoJTextField.getText());
        }

        try {
            Date fecha_inicio = Date.valueOf(AnioFechaInicioJTextField.getText() + "-" + MesFechaInicioJTextField.getText() + "-" + DiaFechaInicioJTextField.getText());

            java.util.Date ahora = Date.from(Instant.now());
            Date fecha_ahora = new Date(ahora.getTime());

            if (nomNoVacio && rutNoVacio && fechaInNoVac && gesONoGES && notif && ConExDes && obser && Fecha.fecha1MenorQueFecha2(fecha_inicio, fecha_termin)) {
                formPaciente.setIpd(new IPDPaciente(RUTJTextField1.getText() + RUTJTextField2.getText(),
                        NombreCompletoJTextField.getText(),
                        fecha_inicio,
                        fecha_termin,
                        GESJCheckBox.isSelected(),
                        SiJCheckBox.isSelected(),
                        ConfirmadoJCheckBox.isSelected(),
                        ExceptuadoJCheckBox.isSelected(),
                        DescartadoJCheckBox.isSelected(),
                        ObservacionJTextArea.getText(),
                        PatologiasJTextField.getText(),
                        p.getRut().getRut(),
                        fecha_ahora, p.getHerramientaPersona().getSecIdByRut(new Rut(RUTJTextField1.getText() + RUTJTextField2.getText()))));
                formPaciente.getConfirmacionIPD().setText("IPD cargado");
                this.formPaciente.setEnabled(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Faltan campos por llenar o Fechas invalidas");
            }
        } catch (java.lang.IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Fecha Invalida");
        }

    }//GEN-LAST:event_AceptarJButtonActionPerformed
    /**
     * Este metodo edita el checkbox GES aparezca seleccionado, y deselecciona
     * el checkbox NoGes
     *
     * @param evt Este evento se genera cuando se hace click en el checkbox GES
     */
    private void GESJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GESJCheckBoxActionPerformed
        // TODO add your handling code here:
        GESJCheckBox.setSelected(true);
        NoGesJCheckBox.setSelected(false);
    }//GEN-LAST:event_GESJCheckBoxActionPerformed
    /**
     * Este metodo edita el checkbox NoGES aparezca seleccionado, y deselecciona
     * el checkbox Ges
     *
     * @param evt Este evento se genera cuando se hace click en el checkbox
     * noGES
     */
    private void NoGesJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoGesJCheckBoxActionPerformed
        // TODO add your handling code here:
        GESJCheckBox.setSelected(false);
        NoGesJCheckBox.setSelected(true);
    }//GEN-LAST:event_NoGesJCheckBoxActionPerformed
    /**
     * Este metodo edita el checkbox Si aparezca seleccionado, y deselecciona el
     * checkbox No
     *
     * @param evt Este evento se genera cuando se hace click en el checkbox Si
     */
    private void SiJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiJCheckBoxActionPerformed
        // TODO add your handling code here:
        SiJCheckBox.setSelected(true);
        NoJCheckBox.setSelected(false);
    }//GEN-LAST:event_SiJCheckBoxActionPerformed
    /**
     * Este metodo edita el checkbox No aparezca seleccionado, y deselecciona el
     * checkbox Si
     *
     * @param evt Este evento se genera cuando se hace click en el checkbox No
     */
    private void NoJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoJCheckBoxActionPerformed
        // TODO add your handling code here:
        SiJCheckBox.setSelected(false);
        NoJCheckBox.setSelected(true);
    }//GEN-LAST:event_NoJCheckBoxActionPerformed
    /**
     * Este metodo edita el checkbox Confirmado aparezca seleccionado, y
     * deselecciona el checkbox Descartado
     *
     * @param evt Este evento se genera cuando se hace click en el checkbox
     * Confirmado
     */
    private void ConfirmadoJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmadoJCheckBoxActionPerformed
        // TODO add your handling code here:
        ConfirmadoJCheckBox.setSelected(true);
        DescartadoJCheckBox.setSelected(false);
    }//GEN-LAST:event_ConfirmadoJCheckBoxActionPerformed
    /**
     * Este metodo edita el checkbox Descartado aparezca seleccionado, y
     * deselecciona el checkbox Confirmado
     *
     * @param evt Este evento se genera cuando se hace click en el checkbox
     * Descartado
     */
    private void DescartadoJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescartadoJCheckBoxActionPerformed
        // TODO add your handling code here:
        ConfirmadoJCheckBox.setSelected(false);
        DescartadoJCheckBox.setSelected(true);
    }//GEN-LAST:event_DescartadoJCheckBoxActionPerformed
    /**
     * Este metodo permite regresar a la ventana de visualizacion de los datos
     * del paciente
     *
     * @param evt Este evento se genera al hacer click en el boton Volver
     */
    private void VolverJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverJButtonActionPerformed
        // TODO add your handling code here:
        if (this.previous == null) {
            this.formPaciente.setEnabled(true);
        } else {
            this.previous.setEnabled(true);
        }
        this.dispose();
    }//GEN-LAST:event_VolverJButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarJButton;
    private javax.swing.JTextField AnioFechaInicioJTextField;
    private javax.swing.JTextField AnioFechaTerminoJTextField;
    private javax.swing.JCheckBox ConfirmadoJCheckBox;
    private javax.swing.JCheckBox DescartadoJCheckBox;
    private javax.swing.JTextField DiaFechaInicioJTextField;
    private javax.swing.JTextField DiaFechaTerminoJTextField;
    private javax.swing.JCheckBox ExceptuadoJCheckBox;
    private javax.swing.JLabel FechaInicioJLabel;
    private javax.swing.JLabel FechaTerminoJLabel;
    private javax.swing.JCheckBox GESJCheckBox;
    private javax.swing.JLabel IPDJLabel;
    private javax.swing.JTextField MesFechaInicioJTextField;
    private javax.swing.JTextField MesFechaTerminoJTextField;
    private javax.swing.JCheckBox NoGesJCheckBox;
    private javax.swing.JCheckBox NoJCheckBox;
    private javax.swing.JLabel NombreCompletoJLabel;
    private javax.swing.JTextField NombreCompletoJTextField;
    private javax.swing.JLabel NotificacionPacienteGesJLabel;
    private javax.swing.JLabel ObservacionJLabel;
    private javax.swing.JScrollPane ObservacionJScrollPane;
    private javax.swing.JTextArea ObservacionJTextArea;
    private javax.swing.JLabel PatologiasJLabel;
    private javax.swing.JTextField PatologiasJTextField;
    private javax.swing.JLabel RUTJLabel;
    private javax.swing.JTextField RUTJTextField1;
    private javax.swing.JTextField RUTJTextField2;
    private javax.swing.JCheckBox SiJCheckBox;
    private javax.swing.JButton VolverJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
