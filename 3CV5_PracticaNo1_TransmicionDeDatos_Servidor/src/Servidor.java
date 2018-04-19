
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author skyli
 */
public class Servidor extends Thread{
    
    private int                     port;
    private int                     sizeBuffer;
    private int                     sizeFile;
    private int                     numberOfFiles;
    private int                     percent;
    private byte []                 buffer;
    private String                  nameFile;
    private String                  direction;
    private String                  extensionFile;
    private Socket                  socketClient;
    private ServerSocket            socketServer;
    private DataInputStream         dataInputStream1;    
    private DataOutputStream        dataOutputStream1;
    private BufferedInputStream     bufferedInputStream1;
    private BufferedOutputStream    bufferedOutputStream1; 
    private Menu                    menu;
    private int                     idFile;
    
    public Servidor(){
        this.port           = 4000;
        this.sizeBuffer     = 102400;
        this.buffer         = new byte[this.sizeBuffer];
    }
    
    public Servidor(int port){
        this.port           = port; 
        this.sizeBuffer     = 102400;
        this.buffer         = new byte[this.sizeBuffer];
    }
    
    public void upConexion(){
        try {
            this.socketServer = new ServerSocket(this.port);          
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recieveNumberOfFiles(){
        try {
            this.dataInputStream1 = new DataInputStream(socketClient.getInputStream());
            this.numberOfFiles = this.dataInputStream1.readInt();
            System.out.println("Número del Archivo: " + this.numberOfFiles);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recieveDataFile(int idFile){
        try {
            this.idFile = idFile;
            System.out.println("\nNúmero del archivo: " + String.valueOf(idFile));
            this.sizeFile = this.dataInputStream1.readInt();
            this.nameFile = this.dataInputStream1.readUTF();
            this.extensionFile = this.dataInputStream1.readUTF();
            System.out.println("\nNombre del archivo: " + this.nameFile);            
            System.out.println("\nExtensión del archivo: " + this.extensionFile);
            System.out.println("\nTamaño del Archivo: " + this.sizeFile);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void recieveFile(){
        boolean flag1,flag2,flag3,flag4;
        flag1 = flag2 = flag3 = flag4 = false;
        try {       
            this.bufferedInputStream1 = new BufferedInputStream(socketClient.getInputStream());
            this.bufferedOutputStream1 = new BufferedOutputStream(new FileOutputStream(this.nameFile+this.extensionFile));
            int bytesRecieved;
            double counter = 0;
            double p = 0.0;
            while((bytesRecieved = this.bufferedInputStream1.read(this.buffer)) != -1){
                this.bufferedOutputStream1.write(buffer, 0, bytesRecieved);
                counter += bytesRecieved;
                p = (counter*100)/(this.sizeFile);
                this.percent = (int) p;
                //System.out.println("Este es el porcentaje: " + this.percent);
                if(this.percent >= 25 && !flag1){
                    System.out.println("Porcentaje: " + this.percent + "%");
                    flag1 = true;
                }
                if(this.percent >= 50 && !flag2){
                    System.out.println("Porcentaje: " + this.percent + "%");
                    flag2 = true;
                }                
                if(this.percent >= 75 && !flag3){
                    System.out.println("Porcentaje: " + this.percent + "%");
                    flag3 = true;
                }        
                if(this.percent >= 100 && !flag4){
                    System.out.println("Porcentaje: " + this.percent + "%");
                    flag4 = true;
                }                
                menu.setBar(this.percent);
            }
            this.bufferedOutputStream1.close();
            this.bufferedInputStream1.close();
            System.out.println("Archivo Recibido");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recieve(){
        menu = new Menu();
        menu.setVisible(true);
        while(true){
            try { 
                this.socketClient = this.socketServer.accept(); 
                recieveNumberOfFiles();
                System.out.println("Este es el numero de archivos: " + this.numberOfFiles);
                for(int i = 0; i < this.numberOfFiles; i++){
                    this.socketClient = this.socketServer.accept();
                    recieveDataFile(i+1);
                    recieveFile();
                    menu.setDataTable(new Object[]{
                        this.idFile,
                        this.nameFile,
                        this.sizeFile,
                        this.extensionFile
                    });
                }               
                this.dataInputStream1.close();
                this.menu.setBar(0);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void destroyer(){        
        this.dataInputStream1 = null;
        this.numberOfFiles = 0; 
        this.sizeFile = 0;
        this.nameFile = null;
        this.extensionFile = null;   
        this.bufferedInputStream1 = null;
        this.bufferedOutputStream1 = null;
    }
    
    public void run(){
        upConexion();
        System.out.println("Servidor en escucha...");
        recieve();
    }
  
    public int getSizeBuffer() {
        return sizeBuffer;
    }

    public void setSizeBuffer(int sizeBuffer) {
        this.sizeBuffer = sizeBuffer;
    }    
    
}
