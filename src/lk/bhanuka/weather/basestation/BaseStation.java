/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.basestation;

import lk.bhanuka.weather.connection.ConnectionManager;

/**
 *
 * @author bhanuka
 */
public class BaseStation {

    private ConnectionManager connectionManager = new ConnectionManager();
    
    private SensorManager sensorManager;

    public BaseStation(){
        this.sensorManager = new SensorManager(this);
    }
    
    public void update(String data){

        if(this.connectionManager.getConnection("localhost", 9999)!= null){
            
            this.connectionManager.getConnection("localhost", 9999).transmit(data);
        }
        else{
            System.out.println(this.connectionManager.getConnection("localhost", 9999));
        }
    }
}
