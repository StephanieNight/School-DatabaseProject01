/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buiss;

import aquiantince.IReadings;
import aquiantince.ISensor;
import aquiantince.SensorType;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Stephanie
 */
public abstract class SensorBase implements ISensor {

    
    private UUID id;
    private double value;
    private SensorType type;
    private ArrayList<IReadings> readings;
    
    SensorBase(SensorType type) {
        
        this.id = new UUID(1, 30);
        this.type = type;
        this.readings = new ArrayList<>();
    }
    
    
    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public SensorType getType() {
        return this.type;
    }

    
    
    
    @Override
    public IReadings[] getReadings() {
        
        IReadings[] list = new IReadings[this.readings.size()];
        
        return this.readings.toArray(list);
        
        
    }

    @Override
    public void makeReading(int id) {
        
        IReadings reading = new SensorReading(id);
        this.addReading(reading);
          
    }

    @Override
    public void addReading(IReadings reading) {
        this.readings.add(reading);
    }
    
    
    @Override
    public String toString() {
        String description = null;
        if(SensorType.Air == type) {
            description = "Air Sensor";
        } else {
            description = "Temperature Sensor";
        }
        return description;
    }
    
    
    
}
