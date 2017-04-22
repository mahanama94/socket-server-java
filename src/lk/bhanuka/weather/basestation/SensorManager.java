/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.basestation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author bhanuka
 */
public class SensorManager{

    private List<Sensor> sensors;
    
    private BaseStation baseStation;
    
    public SensorManager(BaseStation station){
    
        this.baseStation = station;
        
        this.sensors = new ArrayList();
        
        Random r = new Random();
        int c = r.nextInt(10) + 1 ;
        for(int i=0; i < c; i++){
            this.sensors.add(new RainfallSensor( i , this));
        }
        
        c = r.nextInt(10) + 1 ;
        for(int i=0; i < c; i++){
            this.sensors.add(new TemperatureSensor( i + 50, this));
            System.out.println("Added temp sensor");
        }
        
        System.out.println("Temp Seensors : "+ Integer.toString(c));
        
        for(Sensor s: this.sensors){
            s.startSensor();
            
        }
    }
    
    public void update(Sensor sensor, Object arg) {
        System.out.println((String)arg);
        synchronized(this){
            this.baseStation.update((String)arg);
            Random r = new Random();
            int c = r.nextInt(10) + 1;

            if(c < 5){
                sensor.stopSensor();
            }
            
            this.notifyAll();
        }
    }
    
}
