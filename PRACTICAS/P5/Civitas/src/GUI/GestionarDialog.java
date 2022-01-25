/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

import civitas.OperacionInmobiliaria;

/**
 *
 * @author albertollamasgonzalez
 */
public class GestionarDialog extends javax.swing.JDialog {

    /**
     * Creates new form GestionarDialog
     * @param parent
     */
    public GestionarDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        DefaultListModel gestiones = new DefaultListModel<>(); // datos para la lista
        
        ArrayList<String> opciones = new ArrayList<> (Arrays.asList(
                   "Construir casa","Construir hotel",
                   "Terminar"));
        for (String s: opciones){
            gestiones.addElement(s);
        }  //se completan los datos
        listaGestiones.setModel(gestiones); //se le dice a la lista cuáles son esos datos
        this.setVisible(true);
    }
    
    public int getGestion(){
        return this.gestionElegida;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelGestiones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGestiones = new javax.swing.JList<>();
        realizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelGestiones.setText("Gestiones");

        listaGestiones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaGestiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaGestionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaGestiones);

        realizar.setText("Realizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(realizar)
                    .addComponent(labelGestiones)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(454, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelGestiones)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(realizar)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaGestionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaGestionesMouseClicked
        // TODO add your handling code here:
        gestionElegida = listaGestiones.getSelectedIndex();
        dispose();
    }//GEN-LAST:event_listaGestionesMouseClicked

    
    private int gestionElegida=-1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGestiones;
    private javax.swing.JList<String> listaGestiones;
    private javax.swing.JButton realizar;
    // End of variables declaration//GEN-END:variables
}