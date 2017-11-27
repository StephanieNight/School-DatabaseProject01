/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buiss;

import aquiantince.IReadings;
import aquiantince.SensorType;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Stephanie
 */
public class SensorReading implements IReadings {

    private Date time;
    private double value;
    private UUID id;
    private SensorType type;
    
    SensorReading() {
        
        this.id = new UUID(1, 30);
        this.value = Math.random();
        this.time = new Date();
    }
    
    
    @Override
    public Date getTime() {
        return this.time;
    }

    @Override
    public Double getValue() {
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
    
    
    
    
    
}
