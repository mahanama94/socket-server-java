/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhanuka
 */
public class ConnectionManager {
    
    private Map<String, Connection> connections;
    
    public ConnectionManager(){
        this.connections = new HashMap();
    }
    
    public Connection getConnection(String ip, int port){
        try{
            if(this.connections.get(ip +":"+ Integer.toString(port)) == null){
                this.connections.put(ip+":"+Integer.toString(port), new SocketConnection(ip, port));
            }
            return this.connections.get(ip +":"+ Integer.toString(port));
        }
        catch(IOException ex){
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
//        try {
//            return new SocketConnection(ip, port);
//        } catch (IOException ex) {
//            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
    }
    
}
