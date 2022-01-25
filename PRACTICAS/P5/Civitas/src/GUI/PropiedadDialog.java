/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.Jugador;
import java.util.ArrayList;
import civitas.CasillaCalle;
import javax.swing.DefaultListModel;
/**
 *
 * @author albertollamasgonzalez
 */
public class PropiedadDialog extends javax.swing.JDialog {

    /**
     * Creates new form PropiedadDialog
     * @param parent
     */
    public PropiedadDialog(java.awt.Frame parent, Jugador jugador) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.propiedadElegida = -1;
        DefaultListModel propiedades = new DefaultListModel<>(); // datos para la lista
        
        ArrayList<String> opciones = new ArrayList<> ();
        ArrayList<CasillaCalle> prop = jugador.getPropiedades();
        for (int i = 0; i < prop.size(); i++){
            opciones.add(prop.get(i).getNombre());
        }
        for (String s: opciones){
            propiedades.addElement(s);
        }  //se completan los datos
        listPropiedades.setModel(propiedades); //se le dice a la lista cuáles son esos datos
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPropiedades = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPropiedades = new javax.swing.JList<>();
        buttonPropiedades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelPropiedades.setText("Propiedades");

        listPropiedades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listPropiedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPropiedadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPropiedades);

        buttonPropiedades.setText("Realizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPropiedades)
                    .addComponent(jScrollPane1))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelPropiedades)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonPropiedades)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listPropiedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPropiedadesMouseClicked
        // TODO add your handling code here:
        propiedadElegida = listPropiedades.getSelectedIndex();
        dispose();
    }//GEN-LAST:event_listPropiedadesMouseClicked
    
    public int getPropiedad(){
        return this.propiedadElegida;
    }
    
    private int propiedadElegida;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPropiedades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPropiedades;
    private javax.swing.JList<String> listPropiedades;
    // End of variables declaration//GEN-END:variables
}