/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.weather.basestation;

/**
 *
 * @author bhanuka
 */
public class TemperatureSensor extends Sensor{

    static {
        int INTERVAL = 500;
    }
    
    public TemperatureSensor(int i, SensorManager sensorManager) {
        super(i, sensorManager);
    }
    
}
