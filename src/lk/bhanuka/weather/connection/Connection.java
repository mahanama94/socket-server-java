/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.connection;

/**
 *
 * @author bhanuka
 */
public abstract class Connection {
    
    protected String ip; 
    
    protected int portNumber;
    
    public Connection(String ip, int portNumber){
        this.ip = ip;
        this.portNumber = portNumber;
    }
    
    public abstract boolean transmit(String data);
}
