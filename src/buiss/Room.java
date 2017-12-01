/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buiss;

import aquiantince.IRoom;
import aquiantince.ISensor;
import aquiantince.SensorType;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author ulriksandberg
 */
public class Room implements IRoom{

    
    private UUID id;
    private String name = "Hello";
    private ArrayList<ISensor> sensors = new ArrayList<>();
    
    Room(String name) {
        
        this.name = name;
        this.id = new UUID(1, 30);
    }
    
    
    
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UUID getUUID() {
        return this.id;
    }

    @Override
    public ISensor[] getSensors() {
        
        ISensor[] list = new ISensor[this.sensors.size()];
        return this.sensors.toArray(list);
        
    }

    @Override
    public void addSensor(SensorType type) {
        
        ISensor newSensor = null;
        
        if(SensorType.Temp == type.Temp) {
            newSensor = new SensorTemp(type);
        } else {
            newSensor = new SensorCO2(type);
        }
        //newSensor.makeReading();
        this.sensors.add(newSensor);
        
    }
    
    public void removeSensor(ISensor sensor) {
        
        System.out.println("should remove");
        System.out.println(sensors.toString());
        if(sensors.contains(sensor)) {
            System.out.println("removing");
            sensors.remove(sensor);
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
}
