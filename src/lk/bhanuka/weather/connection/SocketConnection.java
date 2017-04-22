/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhanuka
 */
public class SocketConnection extends Connection{
    
    private Socket socket;
    
    public SocketConnection(String ip, int portNumber) throws IOException {
        super(ip, portNumber);
        this.socket = new Socket(ip, portNumber);
    }
    
    public boolean transmit(String data){
        System.out.println("Recieved for transmission : "+ data);
        try {        
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.socket.getOutputStream());
            PrintWriter out = new PrintWriter(outputStreamWriter);
            out.println(data);
            outputStreamWriter.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(SocketConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


//        try {
//            
//            OutputStream outputStream = this.socket.getOutputStream();
//            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            dataOutputStream.writeUTF(data);
//            outputStream.flush();
//            
//            return true;
//        } catch (IOException ex) {
//            Logger.getLogger(SocketConnection.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }

    }
    
}
