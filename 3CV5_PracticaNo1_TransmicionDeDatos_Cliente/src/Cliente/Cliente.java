/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{

    private int                     port;
    private int                     percent;
    private int                     sizeBuffer;
    private byte []                 buffer;
    private String                  direction;
    private Socket                  socketClient;
    private DataOutputStream        dataOutputStream1;
    private BufferedInputStream     bufferedInputStream1;
    private BufferedOutputStream    bufferedOutputStream1;
    private File []                 files;    
    private BarraDeProgreso         Barra;
    
    public Cliente(){
        this.port           = 4000;
        this.direction      = "127.0.0.1";//"192.168.0.3";
        this.sizeBuffer     = 202400;
        this.buffer         = new byte[this.sizeBuffer];     
        //upConexion();
    }
    
    public Cliente(String direction, int port){
        this.port           = port;
        this.direction      = direction;  
        this.sizeBuffer     = 102400;
        this.buffer         = new byte[this.sizeBuffer];  
    }    

    public void upConexion(){
        try {
            this.socketClient = new Socket(this.direction, this.port);
            System.out.println("Cliente conectado...");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendNumberOfFiles(int numberOfFiles){
        try {
            this.dataOutputStream1 = new DataOutputStream(socketClient.getOutputStream());
            this.dataOutputStream1.writeInt(numberOfFiles);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendDataFile(int sizeFile, String nameFile, String extensionFile){
        try {
            this.dataOutputStream1.writeInt(sizeFile);
            this.dataOutputStream1.writeUTF(nameFile);
            this.dataOutputStream1.writeUTF(extensionFile);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public void sendFile(File file, int id, int size){
        try {
            this.bufferedInputStream1 = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));
            this.bufferedOutputStream1 = new BufferedOutputStream(this.socketClient.getOutputStream()); 
            int byteSent = 0;
            double counter = 0.0;
            double p = 0.0;
            while((byteSent = this.bufferedInputStream1.read(this.buffer)) != -1){
                this.bufferedOutputStream1.write(this.buffer, 0, byteSent);
                counter += byteSent;
                p = (counter*100)/((int)file.length());
                this.percent = (int) p;
                Thread.sleep(5);
                this.Barra.setProgress(file.getName().substring(0, file.getName().lastIndexOf('.')), file.getName().substring(file.getName().lastIndexOf('.')+1), id, size, this.percent);
                Thread.sleep(5);
            }
            this.bufferedInputStream1.close();
            this.bufferedOutputStream1.close();
            System.out.println("Archivo Enviado.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }  
    
    public void send(){ 
        this.Barra = new BarraDeProgreso();
        upConexion();
        sendNumberOfFiles(files.length);
        System.out.println("Este es el numero de archivos a Mandar: " + files.length);
        for(int i = 0; i < files.length; i++){
            this.Barra.setVisible(true);
            this.Barra.setProgress(0);
            upConexion();
            System.out.println("\nNúmero de archivo: " + String.valueOf(i+1));
            System.out.println("\nNombre del archivo: " + files[i].getName().substring(0, files[i].getName().lastIndexOf('.')));
            System.out.println("\nExtensión del archivo: " + "." + files[i].getName().substring(files[i].getName().lastIndexOf('.')+1));
            System.out.println("\nTamaño en bytes del archivo: " + String.valueOf(files[i].length()));
            sendDataFile((int) files[i].length(), files[i].getName().substring(0, files[i].getName().lastIndexOf('.')), '.'+files[i].getName().substring(files[i].getName().lastIndexOf('.')+1));
            sendFile(files[i], i+1, (int)files[i].length());
            this.Barra.setVisible(false);
        }
        try {
            this.dataOutputStream1.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.socketClient.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    @Override
    public void run(){
        System.out.println("Cliente Mandando Archivos...");
        send();
    }    
     
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getSizeBuffer() {
        return sizeBuffer;
    }

    public void setSizeBuffer(int sizeBuffer) {
        this.sizeBuffer = sizeBuffer;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Socket getSocketClient() {
        return socketClient;
    }

    public void setSocketClient(Socket socketClient) {
        this.socketClient = socketClient;
    }

    public DataOutputStream getDataOutputStream1() {
        return dataOutputStream1;
    }

    public void setDataOutputStream1(DataOutputStream dataOutputStream1) {
        this.dataOutputStream1 = dataOutputStream1;
    }

    public BufferedInputStream getBufferedInputStream1() {
        return bufferedInputStream1;
    }

    public void setBufferedInputStream1(BufferedInputStream bufferedInputStream1) {
        this.bufferedInputStream1 = bufferedInputStream1;
    }

    public BufferedOutputStream getBufferedOutputStream1() {
        return bufferedOutputStream1;
    }

    public void setBufferedOutputStream1(BufferedOutputStream bufferedOutputStream1) {
        this.bufferedOutputStream1 = bufferedOutputStream1;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public BarraDeProgreso getBarra() {
        return Barra;
    }

    public void setBarra(BarraDeProgreso Barra) {
        this.Barra = Barra;
    }    
    
}
