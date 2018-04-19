/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.File;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skyli
 */
public class Menu extends javax.swing.JFrame {
    
    private Cliente client;
    private BuscadorDeArchivos searcher;
    private DefaultTableModel defaultModel;
    private int buffer;
    private boolean flag;
    private int counter;
        
    public Menu() {
        configurate();
        initComponents();
        prepareData(); 
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        //</editor-fold>        
    }
    
    public void prepareData(){
        setTitle("Cliente");
        this.client = new Cliente();
        String [] Titles = new String[]{"#","File Name", "File Size", "File Extension"};
        this.defaultModel = new DefaultTableModel();
        this.defaultModel.setColumnIdentifiers(Titles);
        this.TableFiles.setModel(this.defaultModel);  
        flag = false; 
        counter=0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableFiles = new javax.swing.JTable();
        btnSend = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBuffer = new javax.swing.JTextField();
        btnBuffer = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        TableFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(TableFiles);

        btnSend.setText("Enviar Archivos");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        jLabel3.setText("Establecer buffer:");

        btnBuffer.setText("Establecer");
        btnBuffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBufferActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar Archivos");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblTitulo.setText("Buscador de archivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuffer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuffer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuffer)
                    .addComponent(btnBuscar)
                    .addComponent(btnSend)
                    .addComponent(btnClean)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:  
        client = new Cliente();         
        client.setFiles(this.searcher.getFiles());
        if(flag)
            client.setSizeBuffer(buffer);
        flag = false;
        client.start();
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnBufferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBufferActionPerformed
        int buffer = Integer.parseInt(this.txtBuffer.getText());
        flag = true;
        JOptionPane.showMessageDialog(null,"El buffer ahora es de: " + txtBuffer.getText());
    }//GEN-LAST:event_btnBufferActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.searcher = new BuscadorDeArchivos();
        this.searcher.seacherFiles();
        File [] f = this.searcher.getFiles();
        counter += f.length;
        for(int i = 0; i < f.length; i++){
            this.defaultModel.addRow(new Object[]{
                String.valueOf(i+1),
                f[i].getName().substring(0, f[i].getName().lastIndexOf('.')),
                String.valueOf(f[i].length()),
                f[i].getName().substring(f[i].getName().lastIndexOf('.')+1),                
            });
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i <= counter; i++){
            defaultModel.removeRow(i);
            i-=1;
        }
        counter=0;
    }//GEN-LAST:event_btnCleanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableFiles;
    private javax.swing.JButton btnBuffer;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuffer;
    // End of variables declaration//GEN-END:variables
}
