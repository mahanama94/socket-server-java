/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhanuka
 */
public class Server extends Thread{

    public static void main(String[] args){
        Server server = new Server();
        server.start();
        
    }
    
    @Override
    public void run(){
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            while(true){
                Socket socketConnection = serverSocket.accept();
                // spawn a thread to handle each connection
                new ServerHandler(socketConnection).start();
                
            }
        }
        catch(Exception ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
