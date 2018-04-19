/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author skyli
 */
public class BarraDeProgreso extends javax.swing.JFrame {


    public BarraDeProgreso() {
        configurate();
        initComponents();
    }
    
    public void configurate(){
       /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarraDeProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarraDeProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarraDeProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarraDeProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProgreso = new javax.swing.JLabel();
        lblNameFile = new javax.swing.JLabel();
        lblSizeFile = new javax.swing.JLabel();
        lblExtensionFile = new javax.swing.JLabel();
        lblNumberFile = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblprogress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProgreso.setText("Progreso");

        lblNameFile.setText(".");

        lblSizeFile.setText("jLabel1");

        lblExtensionFile.setText("jLabel1");

        lblNumberFile.setText("jLabel1");

        lblprogress.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProgreso)
                    .addComponent(lblNameFile)
                    .addComponent(lblSizeFile)
                    .addComponent(lblExtensionFile)
                    .addComponent(lblNumberFile)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblprogress)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProgreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSizeFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblExtensionFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumberFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprogress))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }

    public JLabel getLblExtensionFile() {
        return lblExtensionFile;
    }

    public void setLblExtensionFile(JLabel lblExtensionFile) {
        this.lblExtensionFile = lblExtensionFile;
    }

    public JLabel getLblNameFile() {
        return lblNameFile;
    }

    public void setLblNameFile(JLabel lblNameFile) {
        this.lblNameFile = lblNameFile;
    }

    public JLabel getLblNumberFile() {
        return lblNumberFile;
    }

    public void setLblNumberFile(JLabel lblNumberFile) {
        this.lblNumberFile = lblNumberFile;
    }

    public JLabel getLblProgreso() {
        return lblProgreso;
    }

    public void setLblProgreso(JLabel lblProgreso) {
        this.lblProgreso = lblProgreso;
    }

    public JLabel getLblSizeFile() {
        return lblSizeFile;
    }

    public void setLblSizeFile(JLabel lblSizeFile) {
        this.lblSizeFile = lblSizeFile;
    }
    
    public void setProgress(String n, String ext, int id, int size, int p){
        lblNameFile.setText("Nombre del Archivo: " + n);
        lblExtensionFile.setText("Extensión del Archivo: \n" + ext);
        lblNumberFile.setText("Número de Archivo: " + String.valueOf(id));
        lblSizeFile.setText("Tamaño del Archivo: " + String.valueOf(size));
        lblprogress.setText(p + "%");
        jProgressBar1.setValue(p);
    }
    
    public void setProgress(int p){
        jProgressBar1.setValue(p);
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblExtensionFile;
    private javax.swing.JLabel lblNameFile;
    private javax.swing.JLabel lblNumberFile;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JLabel lblSizeFile;
    private javax.swing.JLabel lblprogress;
    // End of variables declaration//GEN-END:variables
}
