package Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author skyli
 */
public class BuscadorDeArchivos extends javax.swing.JFrame {

    private JFileChooser chooser;
    private File [] files;
    
    public BuscadorDeArchivos(){
        this.chooser = new JFileChooser();
        this.chooser.setMultiSelectionEnabled(true);
    }
    
    public void seacherFiles(){
        int option = chooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            files = chooser.getSelectedFiles();            
        }        
    }
    
    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }   
    
    public void destroyer(){
        this.files = null;
        this.chooser = null;
    }
    
}
