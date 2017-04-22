/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.basestation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhanuka
 */
public abstract class Sensor extends Thread{
    
    private static int INTERVAL = 2000;
    
    private int id;
    
    private int count;
    
    private SensorManager sensorManager;
    
    public Sensor(int id, SensorManager manager){
        this.id = id;
        this.count = 0;
        this.sensorManager = manager;
    }
    
    public void startSensor(){
        this.start();
    }
    
    public void stopSensor(){
        System.out.println("Stopping sensor : "+ Integer.toString(id));
        this.stop();
    }
    
    public void run(){

        while(true){
            try {
                Thread.sleep(Sensor.INTERVAL); 
            } catch (InterruptedException ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.sensorManager.update(this, "Sensor reading " + Integer.toString(this.id)+", Reading : "+ Integer.toString(this.count));
            this.count++;
        }
    }
    
        
}
