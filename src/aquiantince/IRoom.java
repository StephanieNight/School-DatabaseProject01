/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquiantince;

import java.util.UUID;

/**
 *
 * @author ulriksandberg
 */
public interface IRoom {
    
    
    void setName(String name);
    String getName();
    UUID getUUID();
    ISensor[] getSensors();
    void addSensor(SensorType type);
    String toString();
    void removeSensor(ISensor sensor);
    
}
